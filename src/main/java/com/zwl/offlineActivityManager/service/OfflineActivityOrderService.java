package com.zwl.offlineActivityManager.service;

import com.zwl.offlineActivityManager.domain.OfflineActivityOrderDO;

import java.util.List;
import java.util.Map;

public interface OfflineActivityOrderService {
	
	OfflineActivityOrderDO get(String orderNo);
	
	List<OfflineActivityOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineActivityOrderDO offlineActivityOrder);
	
	int update(OfflineActivityOrderDO offlineActivityOrder);
	
	int remove(String orderNo);
	
	int batchRemove(String[] orderNos);

    Integer selectOrderCountByThemeId(Integer id);

    Integer selectOrderCountByActivityId(Integer activityId);
}
