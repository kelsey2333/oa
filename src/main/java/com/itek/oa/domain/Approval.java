/**
 * @Author wpzhang
 * @Date 2019/7/12
 * @Description
 */
package com.itek.oa.domain;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-12 10:57
 **/
public class Approval {
    public Approval(){}
    private Integer id;
    private Integer applyId;
    private Integer approvalId;
    private String approvalType;
    private String result;
    private String advice;

    @Override
    public String toString() {
        return "Approval{" +
                "id=" + id +
                ", applyId=" + applyId +
                ", approvalId=" + approvalId +
                ", approvalType='" + approvalType + '\'' +
                ", result='" + result + '\'' +
                ", advice='" + advice + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Approval(Integer id, Integer applyId, Integer approvalId, String approvalType, String result, String advice) {
        this.id = id;
        this.applyId = applyId;
        this.approvalId = approvalId;
        this.approvalType = approvalType;
        this.result = result;
        this.advice = advice;
    }
}