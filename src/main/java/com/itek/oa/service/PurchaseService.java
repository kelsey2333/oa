package com.itek.oa.service;

import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Approval;
import com.itek.oa.domain.Purchase;

import java.util.List;

public interface PurchaseService {
    ServiceResult<String> addProperties(Purchase purchase);

    ServiceResult<List<Purchase>> selectAllApplies();

    ServiceResult<Purchase> selectDetails(int id);

    ServiceResult<String> handlePropertyApproval(Approval approval);

    void addApprovalHistory(Approval approval);
}
