package com.zwl.userCertificationManager.service.impl;

import com.zwl.userCertificationManager.dao.SaasUserCertificationMapper;
import com.zwl.userCertificationManager.domain.SaasUserCertificationDO;
import com.zwl.userCertificationManager.service.SaasUserCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class SaasUserCertificationServiceImpl implements SaasUserCertificationService {
    @Autowired
    private SaasUserCertificationMapper saasUserCertificationMapper;

    @Override
    public SaasUserCertificationDO get(Long id) {
        return saasUserCertificationMapper.get(id);
    }

    @Override
    public List<SaasUserCertificationDO> list(Map<String, Object> map) {
        return saasUserCertificationMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return saasUserCertificationMapper.count(map);
    }

    @Override
    public int save(SaasUserCertificationDO saasUserCertification) {
        return saasUserCertificationMapper.save(saasUserCertification);
    }

    @Override
    public int update(SaasUserCertificationDO saasUserCertification) {
        saasUserCertification.setModifyTime(new Date());
        return saasUserCertificationMapper.update(saasUserCertification);
    }

    @Override
    public int remove(Long id) {
        return saasUserCertificationMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return saasUserCertificationMapper.batchRemove(ids);
    }

}
