package com.zwl.user.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用户查询传参
 *
 * @author houyuhui
 */
@Data
public class ActivateInfoVvo {
    /**
     * 主题名称
     */
    private Integer themeId;
    /**
     * 商品价格
     */
    private Integer themePrice;
    /**
     * 活动
     */
    private Integer activityId;

}
