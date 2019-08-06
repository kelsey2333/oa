/**
 * @Author wpzhang
 * @Date 2019/7/13
 * @Description
 */
package com.itek.oa.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-13 14:00
 **/
public class Purchase {
    public Purchase(){}
    private Integer id;
    private Integer applyerId;
    private String applyerName;
    private Date applyerTime;
    private String reason;
    private String propertyName;
    private Integer number;
    private Double unitPrice;
    private String status;
    private Integer approvalRoleId;

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", applyerId=" + applyerId +
                ", applyerName='" + applyerName + '\'' +
                ", applyerTime=" + applyerTime +
                ", reason='" + reason + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", number=" + number +
                ", unitPrice=" + unitPrice +
                ", status='" + status + '\'' +
                ", approvalRoleId=" + approvalRoleId +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyerId() {
        return applyerId;
    }

    public void setApplyerId(Integer applyerId) {
        this.applyerId = applyerId;
    }

    public String getApplyerName() {
        return applyerName;
    }

    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }

    public Date getApplyerTime() {
        return applyerTime;
    }

    public void setApplyerTime(Date applyerTime) {
        this.applyerTime = applyerTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getApprovalRoleId() {
        return approvalRoleId;
    }

    public void setApprovalRoleId(Integer approvalRoleId) {
        this.approvalRoleId = approvalRoleId;
    }

    public Purchase(Integer id, Integer applyerId, String applyerName, Date applyerTime, String reason, String propertyName, Integer number, Double unitPrice, String status, Integer approvalRoleId) {
        this.id = id;
        this.applyerId = applyerId;
        this.applyerName = applyerName;
        this.applyerTime = applyerTime;
        this.reason = reason;
        this.propertyName = propertyName;
        this.number = number;
        this.unitPrice = unitPrice;
        this.status = status;
        this.approvalRoleId = approvalRoleId;
    }

    public Purchase(Integer applyerId, String applyerName, String applyerTime, String reason, String propertyName, Integer number, Double unitPrice) throws ParseException {
        this.applyerId = applyerId;
        this.applyerName = applyerName;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date applyerTime2 = sdf.parse(applyerTime);
        this.applyerTime = applyerTime2;
        this.reason = reason;
        this.propertyName = propertyName;
        this.number = number;
        this.unitPrice = unitPrice;
    }
}