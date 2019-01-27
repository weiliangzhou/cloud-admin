package com.zwl.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zwl.classManager.domain.ClaSetItemVo;
import com.zwl.classManager.domain.ClassCategoryItemVo;
import com.zwl.classManager.service.ClasetService;
import com.zwl.classManager.service.ClassCategoryService;
import com.zwl.offlineActivityManager.domain.OfflineActivityThemeItemVo;
import com.zwl.offlineActivityManager.domain.OfflineActivityVo;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import com.zwl.offlineActivityManager.service.OfflineActivityThemeService;
import com.zwl.productManager.domain.ProductItemVo;
import com.zwl.productManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 二师兄超级帅
 * @Title: 下拉框值
 * @ProjectName parent
 * @Description: TODO
 * @date 2018/7/2219:58
 */
@RestController
@RequestMapping("/items")
public class ItemsListController {
    @Autowired
    private OfflineActivityThemeService offlineActivityThemeService;
    @Autowired
    private OfflineActivityService offlineActivityService;
    @Autowired
    private ClasetService clasetService;
    @Autowired
    private ClassCategoryService classCategoryService;
    @Autowired
    private ProductService productService;

    @PostMapping("/getProductList")
    public String getProductList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
        List<ProductItemVo> productItemVoList = productService.getProductItemVoList(merchantId);
        return JSON.toJSONString(productItemVoList);
    }

    @PostMapping("/getActivityItemsList")
    public String getActivityItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
        Integer activityThemeId = jsonObject.getInteger("activityThemeId");
        List<OfflineActivityVo> list = offlineActivityService.getActivityItemsList(merchantId,activityThemeId);
        return JSON.toJSONString(list);
    }

    @PostMapping("/getActivityThemeItemsList")
    public String getActivityThemeItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
        List<OfflineActivityThemeItemVo> list = offlineActivityThemeService.getActivityThemeItemsList(merchantId);
        return JSON.toJSONString(list);
    }

    @PostMapping("/getClassSetItemsList")
    public String getClassSetItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
        Integer categoryId = jsonObject.getInteger("categoryId");
        List<ClaSetItemVo> list = clasetService.getClassSetItemList(categoryId, merchantId);
        return JSON.toJSONString(list);
    }

    @PostMapping("/getClassCategoryItemsList")
    public String getClassCategoryItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
        List<ClassCategoryItemVo> list = classCategoryService.getClassCategoryItemList(merchantId);
        return JSON.toJSONString(list);
    }
}
