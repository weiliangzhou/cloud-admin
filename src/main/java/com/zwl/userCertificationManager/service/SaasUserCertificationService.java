package com.zwl.userCertificationManager.service;

import com.zwl.userCertificationManager.domain.SaasUserCertificationDO;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-19 11:26:46
 */
public interface SaasUserCertificationService {

    SaasUserCertificationDO get(Long id);

    List<SaasUserCertificationDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SaasUserCertificationDO saasUserCertification);

    int update(SaasUserCertificationDO saasUserCertification);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
