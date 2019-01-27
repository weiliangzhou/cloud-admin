package com.zwl.productManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.productManager.domain.ProductDO;
import com.zwl.productManager.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.zwl.common.utils.BigDecimalUtil.mul;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:00:27
 */
@Controller
@RequestMapping("/productManager")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    @RequiresPermissions("productManager:product")
    String Product() {
        return "productManager/product";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("productManager:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);
        List<ProductDO> productList = productService.list(query);
        int total = productService.count(query);
        PageUtils pageUtils = new PageUtils(productList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("productManager:add")
    String add() {
        return "productManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("productManager:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ProductDO product = productService.get(id);
        model.addAttribute("product", product);
        return "productManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("productManager:info")
    public R info(@PathVariable("id") Long id) {
        ProductDO product = productService.get(id);
        return R.ok().put("product", product);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("productManager:save")
    public R save(ProductDO product) {
        product.setPrice(Integer.parseInt((int)mul(product.getPriceDesc(),100)+""));
        product.setLevel(0);
        product.setLevelName("默认");
        product.setMaidPercent(0);
        product.setValidityTime(0);
        product.setMerchantId(ShiroUtils.getMerchantId());
        product.setCreateTime(new Date());
        product.setAvailable(1);
        product.setBuyCount(0);
        product.setIsShow(1);
        if (productService.save(product) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @RequiresPermissions("productManager:update")
    @ResponseBody
    public R update( ProductDO product) {
        product.setPrice(Integer.parseInt((int)mul(product.getPriceDesc(),100)+""));
        productService.update(product);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("productManager:remove")
    public R remove(Long id) {
        if (productService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("productManager:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        productService.batchRemove(ids);

        return R.ok();
    }

}
