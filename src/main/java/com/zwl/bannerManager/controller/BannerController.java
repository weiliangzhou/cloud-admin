package com.zwl.bannerManager.controller;

import com.zwl.bannerManager.domain.BannerDO;
import com.zwl.bannerManager.service.BannerService;
import com.zwl.common.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @author 二师兄
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping()
    @RequiresPermissions("banner:banner")
    String Banner() {
        return "bannerManager/banner";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("banner:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        String merchantId = ShiroUtils.getMerchantId();
        params.put("merchantId", merchantId);
        //查询列表数据
        Query query = new Query(params);
        List<BannerDO> bannerList = bannerService.list(query);
        int total = bannerService.count(query);
        PageUtils pageUtils = new PageUtils(bannerList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("banner:add")
    String add() {
        return "bannerManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("banner:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        BannerDO banner = bannerService.get(id);
        model.addAttribute("banner", banner);
        return "bannerManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("banner:info")
    public R info(@PathVariable("id") Integer id) {
        BannerDO banner = bannerService.get(id);
        return R.ok().put("banner", banner);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
//	@RequiresPermissions("demo:save")
    public R save(BannerDO banner) {
        banner.setMerchantId(ShiroUtils.getMerchantId());
        if (bannerService.save(banner) > 0) {
            //同步刷新或者删除对应的rediskey  getBannerList
            RedisUtil.del("getBannerList");
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ResponseBody
//	@RequiresPermissions("demo:update")
    public R update(BannerDO banner) {
        bannerService.update(banner);
        //同步刷新或者删除对应的rediskey  getBannerList
        RedisUtil.del("getBannerList");

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("banner:remove")
    public R remove(Integer id) {
        if (bannerService.remove(id) > 0) {
            //同步刷新或者删除对应的rediskey  getBannerList
            RedisUtil.del("getBannerList");
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("banner:remove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        bannerService.batchRemove(ids);
        //同步刷新或者删除对应的rediskey  getBannerList
        RedisUtil.del("getBannerList");

        return R.ok();
    }

}
