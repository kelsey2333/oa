package com.itek.oa.dao;

import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Leave;

import java.util.List;

public interface LeaveDao {
    int insertApprovalRoleList(Leave leave);

    List<Leave> selectWillApprovalRecords();

    Leave selectApply(int id);

    int insertApprovalResult(Approval approval);

    String selectApprovalRoleList();

    int updateByApplyId(Leave leave);

    int selectApprovalRoleId(int applyId);
}
