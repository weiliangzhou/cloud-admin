package com.zwl.offlineActivityManager.service;

public interface OfflineActivityCodeService {
    Integer selectIsUsedByActivityCodeAndMerchantId(String activityCode,String merchantId);
}
