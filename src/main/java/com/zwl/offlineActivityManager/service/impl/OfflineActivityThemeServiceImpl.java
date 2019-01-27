package com.zwl.offlineActivityManager.service.impl;

import com.zwl.offlineActivityManager.dao.OfflineActivityThemeMapper;
import com.zwl.offlineActivityManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityThemeItemVo;
import com.zwl.offlineActivityManager.service.OfflineActivityThemeService;
import com.zwl.user.vo.ActivateInfoVvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OfflineActivityThemeServiceImpl implements OfflineActivityThemeService {
    @Autowired
    private OfflineActivityThemeMapper offlineActivityThemeMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public OfflineActivityThemeDO get(Integer id) {
        return offlineActivityThemeMapper.get(id);
    }

    @Override
    public List<OfflineActivityThemeDO> list(Map<String, Object> map) {
        return offlineActivityThemeMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return offlineActivityThemeMapper.count(map);
    }

    @Override
    public int save(OfflineActivityThemeDO offlineActivityTheme) {
        return offlineActivityThemeMapper.save(offlineActivityTheme);
    }

    @Override
    public int update(OfflineActivityThemeDO offlineActivityTheme) {
        int result = offlineActivityThemeMapper.update(offlineActivityTheme);
        //删除Redis缓存 实时生效业务员分享页面
        Set<String> keys = stringRedisTemplate.keys(String.format("*shareimg_%s*", offlineActivityTheme.getId()));
        stringRedisTemplate.delete(keys);
        return result;
    }

    @Override
    public int remove(Integer id) {
        return offlineActivityThemeMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return offlineActivityThemeMapper.batchRemove(ids);
    }

    @Override
    public List<OfflineActivityThemeItemVo> getActivityThemeItemsList(String merchantId) {
        return offlineActivityThemeMapper.getActivityThemeItemsList(merchantId);
    }

    @Override
    public ActivateInfoVvo getThemeIdThemePriceAndActivityIdByThemeName(String themeName) {
        return offlineActivityThemeMapper.getThemeIdThemePriceAndActivityIdByThemeName(themeName);
    }

}
