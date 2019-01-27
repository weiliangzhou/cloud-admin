package com.zwl.offlineActivityManager.service.impl;

import com.zwl.offlineActivityManager.dao.OfflineActivityCodeMapper;
import com.zwl.offlineActivityManager.service.OfflineActivityCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfflineActivityCodeServiceImpl implements OfflineActivityCodeService {
    @Autowired
    private OfflineActivityCodeMapper offlineActivityCodeMapper;

    @Override
    public Integer selectIsUsedByActivityCodeAndMerchantId(String activityCode,String merchantId) {
        return offlineActivityCodeMapper.selectIsUsedByActivityCodeAndMerchantId(activityCode,merchantId);
    }
}
