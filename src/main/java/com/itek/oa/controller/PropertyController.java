/**
 * @Author wpzhang
 * @Date 2019/7/13
 * @Description
 */
package com.itek.oa.controller;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Purchase;
import com.itek.oa.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-13 11:05
 **/
@Controller
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    @Qualifier("purchaseService")
    private PurchaseService purchaseService;
    @RequestMapping("/purchase.do")
    public String addPage(){
        return "property/purchase";
    }

    /*
     *资产申请
     */
    @RequestMapping("/purchase/handle.do")
    public String handlePurchase(String applyerId,String applyerName,String applyerTime,String reason, String propertyName,String number,String unitPrice, Model model) throws ParseException {
     Purchase purchase = new Purchase(Integer.parseInt(applyerId),applyerName,applyerTime,reason,propertyName,Integer.parseInt(number),Double.parseDouble(unitPrice));
     ServiceResult<String> result = purchaseService.addProperties(purchase);
        if (result.getCode() == ResultCode.SUCCESS.getCode()) {
            model.addAttribute("msg","提交申请成功！");
        }else{
            model.addAttribute("msg", result.getData());
        }
        return "property/purchase";
    }
    /*
     *资产审批
     */
    @RequestMapping("/purchase/approval.do")
    public String approvalPurchase(Model model){
        //查询所有申请
        ServiceResult<List<Purchase>> purchaseApplies = purchaseService.selectAllApplies();
        model.addAttribute("applies",purchaseApplies.getData());
        return "property/approval";
    }
    @RequestMapping("/approval/detail/{id}")
    public String applyDetail(@PathVariable int id, Model model){
        //申请详细
        ServiceResult<Purchase> detail = purchaseService.selectDetails(id);
        model.addAttribute("details",detail.getData());
        return "property/approvalDetail";
    }
    /*
     *处理资产审批
     */
    @RequestMapping("/approval/handle.do")
    public String handleApproval(Approval approval,Model model){
        approval.setApprovalType("资产审批");
        //保存审批记录
        purchaseService.addApprovalHistory(approval);
        ServiceResult<String> result = purchaseService.handlePropertyApproval(approval);
        if (result.getCode() == ResultCode.SUCCESS.getCode()){
            model.addAttribute("msg","审批成功!");
        }else{
            model.addAttribute("msg",result.getData());
        }
        return "property/approvalDetail";
    }
}