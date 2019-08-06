/**
 * @Author wpzhang
 * @Date 2019/7/11
 * @Description
 */
package com.itek.oa.service;

import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Leave;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-11 14:33
 **/
public interface LeaveService {

    ServiceResult<String> handleApply(Leave leave);

    ServiceResult<List<Leave>> selectWillApprovalRecords();

    ServiceResult<Leave> selectApplyDetails(int id);

    ServiceResult<String> handleApproval(Approval approval);
}