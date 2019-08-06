/**
 * @Author wpzhang
 * @Date 2019/7/11
 * @Description
 */
package com.itek.oa.service.Impl;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.dao.ApprovalListDao;
import com.itek.oa.dao.LeaveDao;
import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Leave;
import com.itek.oa.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-11 14:33
 **/
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private ApprovalListDao approvalListDao;
    @Autowired
    private LeaveDao leaveDao;

    @Override
    public ServiceResult<String> handleApply(Leave leave) {
        /**
         * 中途插入approval_role_id
         * 查询t_approval_list表中的流程字段：approval_role_list拆分后插入
         * 到t_leava表中的最后一个字段：approval_role_id中
         */
        //todo 封装
      String listStr = approvalListDao.selectApprovalRoleList("请假审批");
      String[] listArr = listStr.split(",");
      leave.setApprovalRoleId(Integer.parseInt(listArr[0]));

      ServiceResult<String> result = new ServiceResult<>();
      //设置审批状态为待审批状态
      leave.setStatus("0");
      //插入到t_leave表中的approval_role_list字段中
      int count = leaveDao.insertApprovalRoleList(leave);
      if (count != 1){
          result.setServiceResult(ResultCode.USERNAME_OR_PASSWORD_ERROR);
      }
      return result;
    }

    @Override
    public ServiceResult<List<Leave>> selectWillApprovalRecords() {
        ServiceResult<List<Leave>> result = new ServiceResult<>();
        List<Leave> records = leaveDao.selectWillApprovalRecords();
        if (records != null){
            result.setData(records);
        }else{
            result.setMsg("您还没有待审批的记录");
        }
        return result;
    }

    @Override
    public ServiceResult<Leave> selectApplyDetails(int id) {
        ServiceResult<Leave> result = new ServiceResult<>();
        Leave details = leaveDao.selectApply(id);
        if (details != null){
            result.setData(details);
        }else{
            result.setMsg("查看详细失败！");
        }
        return result ;
    }

    @Override
    public ServiceResult<String> handleApproval(Approval approval) {
        Integer updateCount = null;
        ServiceResult<String> result = new ServiceResult<>();
        leaveDao.insertApprovalResult(approval);
        int applyId = approval.getApplyId();
        Leave leave = new Leave();
        leave.setId(applyId);
        //再通过该applyId 获取到t_leave表中的approval_role_id字段
        int approvalRoleId =leaveDao.selectApprovalRoleId(applyId);
        //判断其中的result是否为1
        String approvalResult = approval.getResult();
        if (approvalResult.equals("1")){
            //一、审批通过
            //查询出t_approval_list表中的approval_role_list字段
           String roleListStr = leaveDao.selectApprovalRoleList();
           //将该字符串拆分成数组
           String[] roleListArr = roleListStr.split(",");
           //判断当前审批人的id是否是该数组的最后一个元素
            if (approvalRoleId == Integer.parseInt(roleListArr[roleListArr.length - 1])){
                //4.1是最后一个元素,将status修改为1,approval_role_id修改为当前审批者roleId,
                leave.setStatus("1");
                leave.setApprovalRoleId(approvalRoleId);
                //进行修改
                updateCount = leaveDao.updateByApplyId(leave);
            }else{
                //5、不是最后一个位置,则获取其在roleListArr数组中的索引位置
                //5.1leave表中的status值仍为“0”，将该index+1的值赋值给approval_role_id字段
                for (int index = 0 ; index <= roleListArr.length-1 ; index++){
                    if (Integer.parseInt(roleListArr[index])== approvalRoleId){
                        leave.setApprovalRoleId(Integer.parseInt(roleListArr[index+1]));
                        updateCount =  leaveDao.updateByApplyId(leave);
                    }
                }
            }
        }else{
            //二、审批不通过
            leave.setStatus("2");
            leave.setApprovalRoleId(approvalRoleId);
            updateCount = leaveDao.updateByApplyId(leave);
        }
            if (updateCount != 1){
                result.setData("审批失败");
            }
            return result;
    }
}