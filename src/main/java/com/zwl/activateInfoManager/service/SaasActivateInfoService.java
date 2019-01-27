package com.zwl.activateInfoManager.service;

import com.zwl.activateInfoManager.domain.SaasActivateInfoDO;
import com.zwl.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-13 18:10:09
 */
public interface SaasActivateInfoService {
    SaasActivateInfoDO get(Integer id);

    List<SaasActivateInfoDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SaasActivateInfoDO saasActivateInfo);

    int update(SaasActivateInfoDO saasActivateInfo);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    /**
     * 导入excle
     */
    R insertExcelToDB(MultipartFile file) throws IOException;

    int updateSendMsg(Integer id, Integer code, String remark);
}
