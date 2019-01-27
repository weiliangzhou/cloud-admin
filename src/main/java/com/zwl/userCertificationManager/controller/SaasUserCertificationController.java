package com.zwl.userCertificationManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.userCertificationManager.domain.SaasUserCertificationDO;
import com.zwl.userCertificationManager.service.SaasUserCertificationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-19 11:26:46
 */
@Controller
@RequestMapping("/certificationManager")
public class SaasUserCertificationController {
    @Autowired
    private SaasUserCertificationService saasUserCertificationService;

    @GetMapping()
    @RequiresPermissions("certificationManager:certificationManager")
    String SaasUserCertification() {
        return "userCertificationManager/list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("certificationManager:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SaasUserCertificationDO> saasUserCertificationList = saasUserCertificationService.list(query);
        int total = saasUserCertificationService.count(query);
        PageUtils pageUtils = new PageUtils(saasUserCertificationList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("certificationManager:add")
    String add() {
        return "demo/userCertificationManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("certificationManager:edit")
    String edit(Model model, @PathVariable("id") Long id) {
        SaasUserCertificationDO saasUserCertification = saasUserCertificationService.get(id);
        model.addAttribute("userCertification", saasUserCertification);
        return "userCertificationManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("demo:info")
    public R info(@PathVariable("id") Long id) {
        SaasUserCertificationDO saasUserCertification = saasUserCertificationService.get(id);
        return R.ok().put("userCertificationManager", saasUserCertification);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("demo:save")
    public R save(SaasUserCertificationDO saasUserCertification) {
        if (saasUserCertificationService.save(saasUserCertification) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequiresPermissions("certificationManager:update")
    @ResponseBody
    @PostMapping("/update")
    public R update(SaasUserCertificationDO saasUserCertification) {
        saasUserCertificationService.update(saasUserCertification);

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(Long id) {
        if (saasUserCertificationService.remove(id) > 0) {
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
    public R remove(@RequestParam("ids[]") Long[] ids) {
        saasUserCertificationService.batchRemove(ids);

        return R.ok();
    }

}
