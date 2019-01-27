package com.zwl.offlineActivityManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OfflineActivityThemeDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //id
    private Integer id;
    //主题名称
    private String themeName;
    //图片地址或者视频地址
    private String themeHrefUrl;
    //类型 0图片 1视频
    private Integer themeType;
    //简介（带格式）
    private String content;
    //简介（不带格式）
    private String contentText;
    //收听人数
    private Integer buyCount;
    /**
     * 限制人数
     */
    private Integer limitCount;
    /**
     * 价格
     */
    private Integer price;
    //是否推荐，0不推荐，1推荐
    private Integer isRecommend;
    //是否展示，0不展示，1展示
    private Integer isShow;
    //图片地址
    private String imgUrl;
    //时长 3天2夜
    private String activityTime;
    //
    private Date createTime = new Date();
    //
    private Date modifyTime;
    //
    private Integer available = 1;
    //
    private String merchantId;
    //天
    private Integer day;
    //夜
    private Integer night;
    //订单人数
    private Integer orderCount;
    //二维码背景图
    private String qrBgImg;
    //开课城市
    private String city;
    //价格
    private Double priceDesc;

    //0不显示 1显示
    private Integer realNameShow;
    //0不显示 1显示
    private Integer phoneShow;
    //0不显示 1显示
    private Integer idCardNumShow;
    //0不显示 1显示
    private Integer addressShow;
    //0不显示 1显示
    private Integer ppShow;
    //0不显示 1显示
    private Integer zyShow;
}
