package com.zwl.user.dao;

import com.zwl.user.domain.SaasUserInfoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 用户基本信息表
 *
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-26 10:24:57
 */
public interface SaasUserInfoMapper {

    /**
     * 查询用户信息
     *
     * @param userId 用户标识符
     * @return 用户对象
     */
    SaasUserInfoDO getUserInfoByUserId(@Param("userId") String userId);

    List<SaasUserInfoDO> list(Map<String, Object> map);

    int save(SaasUserInfoDO saasUserInfo);

    int update(SaasUserInfoDO saasUserInfo);

}
