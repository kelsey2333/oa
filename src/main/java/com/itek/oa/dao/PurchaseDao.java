/**
 * @Author wpzhang
 * @Date 2019/7/13
 * @Description
 */
package com.itek.oa.dao;

import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Purchase;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-13 14:16
 **/
public interface PurchaseDao {
    int insertProperties(Purchase purchase);

    List<Purchase> selectAllApplies();

    Purchase selectDetails(int id);

    int selectApprovalRoleIdById(int approvalId);

    String selectApprovalRoleList(String approvalName);

    int updateById(Purchase purchase);

    void insertApprovalHistory(Approval approval);
}