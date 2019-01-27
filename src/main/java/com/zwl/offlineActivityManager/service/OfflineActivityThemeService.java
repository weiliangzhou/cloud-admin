package com.zwl.offlineActivityManager.service;

import com.zwl.offlineActivityManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityThemeItemVo;
import com.zwl.user.vo.ActivateInfoVvo;

import java.util.List;
import java.util.Map;

public interface OfflineActivityThemeService {
	
	OfflineActivityThemeDO get(Integer id);
	
	List<OfflineActivityThemeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineActivityThemeDO offlineActivityTheme);
	
	int update(OfflineActivityThemeDO offlineActivityTheme);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<OfflineActivityThemeItemVo> getActivityThemeItemsList(String merchantId);

	ActivateInfoVvo getThemeIdThemePriceAndActivityIdByThemeName(String themeName);

}
