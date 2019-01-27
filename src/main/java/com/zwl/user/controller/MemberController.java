package com.zwl.user.controller;

import com.github.pagehelper.PageInfo;
import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.R;
import com.zwl.user.domain.MemberDO;
import com.zwl.user.service.MemberService;
import com.zwl.user.vo.MemberVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houyuhui
 */
@Controller
@RequestMapping("/memberManager")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 用户列表
     */
    @GetMapping("/dispatchUserList")
    @RequiresPermissions("userMemberManager:userMemberManager")
    public String dispatchUserList(@RequestParam(value = "referrerId", required = false) String referrerId, ModelMap modelMap) {
        modelMap.put("referrerId", referrerId);
        return "memberManager/userMember";
    }

    /**
     * 业务员列表
     */
    @GetMapping("/dispatchSalesmanList")
    @RequiresPermissions("salesmanManager:salesmanManager")
    public String dispatchSalesmanList() {
        return "memberManager/salemanMember";
    }


    @ResponseBody
    @GetMapping("/userMemberList")
    @RequiresPermissions("userMemberManager:list")
    public PageUtils userMemberList(@ModelAttribute MemberVo params) {
        if (params.getMemberType() == null || params.getMemberType().isEmpty()) {
            List<Integer> memberType = new ArrayList<>();
            memberType.add(1);
            memberType.add(2);
            params.setMemberType(memberType);
        }
        PageInfo<MemberDO> result = memberService.findUserListsPage(params);
        return new PageUtils(result);
    }

    @ResponseBody
    @GetMapping("/salesmanMemberList")
    @RequiresPermissions("salesmanManager:list")
    public PageUtils salesmanMemberList(@ModelAttribute MemberVo params) {
        List<Integer> memberType = new ArrayList<>();
        memberType.add(99);
        params.setMemberType(memberType);
        PageInfo<MemberDO> result = memberService.findSalesmanUserListsPage(params);
        return new PageUtils(result);
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("offlineActivityOperator:remove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {

        return R.ok();
    }

}
