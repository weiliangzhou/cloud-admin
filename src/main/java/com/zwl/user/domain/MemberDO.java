package com.zwl.user.domain;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息实体类
 */
@Data
public class MemberDO {

    /**
     * 用户标识
     */
    private String userId;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 注册来源 0:网页 1:微信-H5 2: 微信-小程序 3:线下导入 4:ios 5 :android
     */
    private Integer registerFrom;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 别名
     */
    private String nickName;
    /**
     * 头像
     */
    private String logoUrl;
    /**
     * 绑定的微信号
     */
    private String wechatNo;
    /**
     * 用户级别 1:普通会员 2:认证会员 99:业务员
     */
    private Integer memberLevel;
    /**
     * 商户号
     */
    private String merchantId;
    /**
     * 绑定的业务员
     */
    private String referrer;
    /**
     * 业务员真实姓名
     */
    private String referrerName;
    /**
     * 第三方帐号标识
     */
    private String openId;
    /**
     * 第三方类型 0:网页 1:微信-H5 2: 微信-小程序 3:线下导入 4:ios 5 :android'
     */
    private Integer channelId;
    /**
     * 注册时间
     */
    private Date registerTime;
}
