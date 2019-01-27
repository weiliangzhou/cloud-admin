package com.zwl.offlineActivityManager.service;

import com.zwl.offlineActivityManager.domain.OfflineActivityOperatorDO;

import java.util.List;
import java.util.Map;

public interface OfflineActivityOperatorService {
	
	OfflineActivityOperatorDO get(Integer id);
	
	List<OfflineActivityOperatorDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineActivityOperatorDO saasOfflineActivityOperator);
	
	int update(OfflineActivityOperatorDO saasOfflineActivityOperator);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
