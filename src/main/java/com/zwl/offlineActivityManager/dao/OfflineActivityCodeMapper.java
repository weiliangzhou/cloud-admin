package com.zwl.offlineActivityManager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OfflineActivityCodeMapper {
    @Select("select is_used from saas_offline_activity_code where activity_code = #{activityCode} and available = 1 and merchant_id = #{merchantId}")
    Integer selectIsUsedByActivityCodeAndMerchantId(@Param("activityCode") String activityCode,@Param("merchantId") String merchantId);
}
