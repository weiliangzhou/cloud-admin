package com.zwl.user.dao;

import com.zwl.user.domain.MemberDO;
import com.zwl.user.vo.MemberVo;

import java.util.List;

/**
 * @author houyuhui
 */
public interface MemberMapper {

    /**
     * 查询会员用户列表
     *
     * @param query 参数
     * @return 列表
     */
    public List<MemberDO> findUserListPage(MemberVo query);
}
