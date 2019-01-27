package com.zwl.offlineActivityManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityOrderDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityManager.service.OfflineActivityCodeService;
import com.zwl.offlineActivityManager.service.OfflineActivityOrderService;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import com.zwl.offlineActivityManager.service.OfflineActivityThemeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/offlineActivityOrder")
public class OfflineActivityOrderController {
    @Autowired
    private OfflineActivityOrderService offlineActivityOrderService;
    @Autowired
    private OfflineActivityService offlineActivityService;
    @Autowired
    private OfflineActivityThemeService offlineActivityThemeService;
    @Autowired
    private OfflineActivityCodeService offlineActivityCodeService;

    @GetMapping()
    @RequiresPermissions("offlineActivityOrder:offlineActivityOrder")
    String OfflineActivityOrder(@RequestParam(value = "userId", required = false) String userId, ModelMap modelMap) {
        modelMap.put("userId", userId);
        return "offlineActivityOrderManager/offlineActivityOrder";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("offlineActivityOrder:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        String merchantId = ShiroUtils.getMerchantId();
        params.put("merchantId", merchantId);
        params.put("available", 1);
        Query query = new Query(params);
        List<OfflineActivityOrderDO> offlineActivityOrderList = offlineActivityOrderService.list(query);
        for (OfflineActivityOrderDO offlineActivityOrderDO : offlineActivityOrderList) {
            if(null != offlineActivityOrderDO.getActivityId()){
                OfflineActivityDO offlineActivityDO = offlineActivityService.get(offlineActivityOrderDO.getActivityId());
                offlineActivityOrderDO.setActivityAddress(offlineActivityDO.getActivityAddress());
            }
            OfflineActivityThemeDO offlineActivityThemeDO = offlineActivityThemeService.get(offlineActivityOrderDO.getActivityThemeId());
            offlineActivityOrderDO.setThemeName(offlineActivityThemeDO.getThemeName());
            //根据activityCode查询该消费码是否已被使用，作为“上课状态”字段
            String activityCode = offlineActivityOrderDO.getActivityCode();
            if (StringUtils.isNotBlank(activityCode)) {
                Integer isUsed = offlineActivityCodeService.selectIsUsedByActivityCodeAndMerchantId(offlineActivityOrderDO.getActivityCode(), merchantId);
                offlineActivityOrderDO.setIsUsed(isUsed);
            }
        }
        int total = offlineActivityOrderService.count(query);
        PageUtils pageUtils = new PageUtils(offlineActivityOrderList, total);
        return pageUtils;
    }

    @GetMapping("/add")
        //@RequiresPermissions("blog:bComments")
    String add() {
        return "demo/offlineActivityOrder/add";
    }

    @GetMapping("/edit")
        //@RequiresPermissions("blog:bComments")
    String edit(String orderNo, Model model) {
        OfflineActivityOrderDO offlineActivityOrder = offlineActivityOrderService.get(orderNo);
        model.addAttribute("offlineActivityOrder", offlineActivityOrder);
        return "demo/offlineActivityOrder/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{orderNo}")
//	@RequiresPermissions("demo:info")
    String info(@PathVariable("orderNo") String orderNo, Model model) {
        OfflineActivityOrderDO offlineActivityOrder = offlineActivityOrderService.get(orderNo);
        OfflineActivityDO offlineActivityDO = offlineActivityService.get(offlineActivityOrder.getActivityId());
        offlineActivityOrder.setActivityAddress(offlineActivityDO.getActivityAddress());
        OfflineActivityThemeDO offlineActivityThemeDO = offlineActivityThemeService.get(offlineActivityOrder.getActivityThemeId());
        offlineActivityOrder.setThemeName(offlineActivityThemeDO.getThemeName());
        model.addAttribute("offlineActivityOrder", offlineActivityOrder);
        return "offlineActivityOrderManager/info";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("demo:save")
    public R save(OfflineActivityOrderDO offlineActivityOrder) {
        if (offlineActivityOrderService.save(offlineActivityOrder) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("demo:update")
    public R update(@RequestBody OfflineActivityOrderDO offlineActivityOrder) {
        offlineActivityOrderService.update(offlineActivityOrder);

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(String orderNo) {
        if (offlineActivityOrderService.remove(orderNo) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(@RequestParam("ids[]") String[] orderNos) {
        offlineActivityOrderService.batchRemove(orderNos);

        return R.ok();
    }

}
