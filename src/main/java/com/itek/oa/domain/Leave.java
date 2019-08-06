/**
 * @Author wpzhang
 * @Date 2019/7/10
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
 * @create: 2019-07-10 18:27
 **/
public class Leave {
    public Leave(){}
    private Integer id;
    private Integer applyerId;
    private String applyerName;
    private Date startTime;
    private Date endTime;
    private Date createTime;
    private String reason;
    private String status;
    private Integer approvalRoleId;


    public Integer getApplyerId() {
        return applyerId;
    }

    public void setApplyerId(Integer applyerId) {
        this.applyerId = applyerId;
    }

    public Integer getApprovalRoleId() {
        return approvalRoleId;
    }

    public void setApprovalRoleId(Integer approvalRoleId) {
        this.approvalRoleId = approvalRoleId;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", applyerId=" + applyerId +
                ", applyerName=" + applyerName +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", approvalRoleId=" + approvalRoleId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyerName() {
        return applyerName;
    }

    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Leave(Integer id, Integer applyerId, String applyerName, String startTime, String endTime, String createTime, String reason, String status, Integer approvalRoleId) throws ParseException {
        this.id = id;
        this.applyerId = applyerId;
        this.applyerName = applyerName;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startTime2 = sdf.parse(startTime);
        Date endTime2 = sdf.parse(endTime);
        Date createTime2 = sdf.parse(createTime);
        this.startTime = startTime2;
        this.endTime = endTime2;
        this.createTime = createTime2;
        this.reason = reason;
        this.status = status;
        this.approvalRoleId = approvalRoleId;
    }

    public Leave(Integer applyerId, String applyerName,String startTime, String endTime,Date createTime,String reason) throws ParseException {
        this.applyerId = applyerId;
        this.applyerName = applyerName;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startTime2 = sdf.parse(startTime);
        Date endTime2 = sdf.parse(endTime);
        this.startTime = startTime2;
        this.endTime = endTime2;
        String dateStr =  sdf.format(createTime);
        Date createTime2 = sdf.parse(dateStr);
        this.createTime = createTime2;
        this.reason = reason;
    }
}