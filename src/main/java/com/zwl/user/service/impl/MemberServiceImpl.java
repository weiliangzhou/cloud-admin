package com.zwl.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwl.user.dao.MemberMapper;
import com.zwl.user.domain.MemberDO;
import com.zwl.user.domain.SaasUserInfoDO;
import com.zwl.user.service.MemberService;
import com.zwl.user.service.SaasUserInfoService;
import com.zwl.user.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houyuhui
 */
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private SaasUserInfoService saasUserInfoService;

    @Override
    public PageInfo<MemberDO> findUserListsPage(MemberVo param) {
        if (null == param) {
            log.error("参数错误");
            return null;
        }
        try {
            param.setMerchantId("1365616402");
            PageHelper.startPage(param.getOffset() / param.getLimit() + 1, param.getLimit());
            List<MemberDO> result = memberMapper.findUserListPage(param);
            fullUserInfo(result);
            return new PageInfo<MemberDO>(result);
        } catch (Exception e) {
            log.error("分页查询会员列表出错", e);
        }
        return null;
    }

    @Override
    public PageInfo<MemberDO> findSalesmanUserListsPage(MemberVo params) {
        if (null == params) {
            log.error("参数错误");
            return null;
        }
        try {
            params.setMerchantId("1365616402");
            PageHelper.startPage(params.getOffset() / params.getLimit() + 1, params.getLimit());
            List<MemberDO> result = memberMapper.findUserListPage(params);
            return new PageInfo<MemberDO>(result);
        } catch (Exception e) {
            log.error("分页查询会员列表出错", e);
        }
        return null;
    }

    private void fullUserInfo(List<MemberDO> memberDOs) {
        if (null == memberDOs || memberDOs.isEmpty()) {
            return;
        }
        Map<String, String> realNameCache = new HashMap<>(10);
        for (MemberDO memberDO : memberDOs) {
            if (null == memberDO || StringUtils.isBlank(memberDO.getReferrer())) {
                return;
            }
            String realName = realNameCache.get(memberDO.getReferrer());
            if (StringUtils.isBlank(realName)) {
                SaasUserInfoDO userInfoDO = saasUserInfoService.getUserInfoByUserId(memberDO.getReferrer());
                realName = userInfoDO.getRealName();
                //重复的referrer连续存在比较多简单缓存一下
                realNameCache.put(memberDO.getReferrer(), realName);
            }
            memberDO.setReferrerName(realName);
        }
    }

}
