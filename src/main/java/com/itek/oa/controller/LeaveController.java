/**
 * @Author wpzhang
 * @Date 2019/7/10
 * @Description
 */
package com.itek.oa.controller;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Leave;
import com.itek.oa.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-10 18:21
 **/
@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    @Qualifier("leaveService")
    private LeaveService leaveService;
    /*
    请假申请页面
     */
    @RequestMapping("/apply.do")
    public String addPage(){
        return "leave/apply";
    }
    /*
    处理请假申请:保存到数据库
     */
    @RequestMapping(value = "/apply/handle.do",method = RequestMethod.POST)
    public String handleApply(String applyerId,String applyerName,String startTime,String endTime ,String reason , Model model) throws ParseException {
        //将startTime endTime转化成date类型
        Date createTime = new Date();
        Leave leave = new Leave(Integer.parseInt(applyerId),applyerName,startTime,endTime,createTime,reason);
       ServiceResult<String> result = leaveService.handleApply(leave);
       if (result.getCode() == ResultCode.SUCCESS.getCode()){
           model.addAttribute("msg","请假申请成功！");
       }else{
           model.addAttribute("msg","请假申请失败！");
       }
        return "leave/apply";
    }
    @RequestMapping("/approval.do")
    public String approvalPage(Model model){
        //查询所有待审批的请假记录
       ServiceResult<List<Leave>> result = leaveService.selectWillApprovalRecords();
       if (result.getCode() == ResultCode.SUCCESS.getCode()){
           model.addAttribute("records",result.getData());
       }else{
           model.addAttribute("msg",result.getMsg());
       }
        return "leave/approval";
    }
    //查看详细界面
    @RequestMapping("/approval/detail/{id}")
    public String approvalDetailPage(@PathVariable int id, Model model){
        ServiceResult<Leave> details = leaveService.selectApplyDetails(id);
        if (details.getCode() == ResultCode.SUCCESS.getCode()){
            model.addAttribute("details",details.getData());
        }else{
            model.addAttribute("msg",details.getMsg());
        }
        return "/leave/approvalDetail";
    }
    @RequestMapping("/approval/handle.do")
    public String approvalHandle(Approval approval,Model model){
        //保存审批记录
        approval.setApprovalType("请假申请");
        ServiceResult<String> result = leaveService.handleApproval(approval);
        if (result.getCode() == ResultCode.SUCCESS.getCode()){
            model.addAttribute("msg","审批成功");
        }else{
            model.addAttribute("msg",result.getData());
        }
        return "leave/approvalDetail";
    }
}