/**
 * @Author wpzhang
 * @Date 2019/7/13
 * @Description
 */
package com.itek.oa.service.Impl;

import com.itek.oa.commons.ServiceResult;
import com.itek.oa.dao.PurchaseDao;
import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Purchase;
import com.itek.oa.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-13 14:09
 **/
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    ServiceResult<String> result = new ServiceResult<>();
    @Override
    public ServiceResult<String> addProperties(Purchase purchase) {
       int count = purchaseDao.insertProperties(purchase);
       if (count != 1){
           result.setData("提交申请失败");
       }
       return result;
    }

    @Override
    public ServiceResult<List<Purchase>> selectAllApplies() {
        ServiceResult<List<Purchase>> purchaseApplies = new ServiceResult<>();
       List<Purchase> applies = purchaseDao.selectAllApplies();
       purchaseApplies.setData(applies);
       return purchaseApplies;
    }

    /**
     * 查看详细具体界面
     * @param id
     * @return
     */
    @Override
    public ServiceResult<Purchase> selectDetails(int id) {
        ServiceResult<Purchase> result = new ServiceResult<>();
        Purchase detail = purchaseDao.selectDetails(id);
       result.setData(detail);
       return result;

    }

    @Override
    public ServiceResult<String> handlePropertyApproval(Approval approval) {
        ServiceResult<String> result = new ServiceResult<>();
        Purchase purchase = new Purchase();
        //获取当前该条申请记录的id
        int applyId = approval.getApplyId();
        purchase.setId(applyId);
        //通过审批者id查询审批者角色id
        int approvalId = approval.getApprovalId();
        int approvalRoleId = purchaseDao.selectApprovalRoleIdById(approvalId);
        //取出result结果进行判断
        if ("1".equals(approval.getResult())){
            //通过
            //查询流程表中的审批名字为“资产审批”的approval_role_list字段
            String approvalName = approval.getApprovalType();
           String approvalRoleListStr =  purchaseDao.selectApprovalRoleList(approvalName);
           //对字符串进行拆分
           String[] approvalRoleList = approvalRoleListStr.split(",");
           if (approvalRoleId ==Integer.parseInt(approvalRoleList[approvalRoleList.length-1])){
                purchase.setStatus("1");
                purchase.setApprovalRoleId(approvalRoleId);
           }else {
               for (int i = 0 ; i < approvalRoleList.length ; i++){
                   if (Integer.parseInt(approvalRoleList[i]) == approvalRoleId){
                       purchase.setApprovalRoleId(Integer.parseInt(approvalRoleList[i+1]));
                   }
               }
           }
        }else{
            //不通过
            purchase.setStatus("2");
            purchase.setApprovalRoleId(approvalRoleId);
        }
        int count = purchaseDao.updateById(purchase);
        if (count != 1){
            result.setData("审批失败!");
        }
        return result;
    }

    @Override
    public void addApprovalHistory(Approval approval) {
        purchaseDao.insertApprovalHistory(approval);
    }
}