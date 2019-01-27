package com.zwl.user.service;

import com.github.pagehelper.PageInfo;
import com.zwl.user.domain.MemberDO;
import com.zwl.user.vo.MemberVo;

/**
 * @author houyuhui
 */
public interface MemberService {

    /**
     * 分页查询用户信息
     *
     * @param params 参数
     * @return 返回分页信息
     */
    public PageInfo<MemberDO> findUserListsPage(MemberVo params);

    /**
     * 分页查询业务员信息列表
     */
    public PageInfo<MemberDO> findSalesmanUserListsPage(MemberVo params);
}
