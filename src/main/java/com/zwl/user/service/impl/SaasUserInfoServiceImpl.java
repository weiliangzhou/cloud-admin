package com.zwl.user.service.impl;

import com.zwl.user.dao.SaasUserInfoMapper;
import com.zwl.user.domain.SaasUserInfoDO;
import com.zwl.user.service.SaasUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author houyuhui
 */
@Service
@Slf4j
public class SaasUserInfoServiceImpl implements SaasUserInfoService {
    @Autowired
    private SaasUserInfoMapper saasUserInfoMapper;

    @Override
    public SaasUserInfoDO getUserInfoByUserId(String userId) {
        if (StringUtils.isBlank(userId)) {
            log.error("请输入要查询的用户编号");
            return null;
        }
        SaasUserInfoDO saasUserInfoDO = saasUserInfoMapper.getUserInfoByUserId(userId);
        return saasUserInfoDO;
    }

    @Override
    public List<SaasUserInfoDO> list(Map<String, Object> map) {
        return saasUserInfoMapper.list(map);
    }

    @Override
    public int save(SaasUserInfoDO saasUserInfo) {
        return saasUserInfoMapper.save(saasUserInfo);
    }

    @Override
    public int update(SaasUserInfoDO saasUserInfo) {
        return saasUserInfoMapper.update(saasUserInfo);
    }


}
