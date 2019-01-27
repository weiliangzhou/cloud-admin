package com.zwl.user.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户查询传参
 *
 * @author houyuhui
 */
@Data
public class ActivateInfoVo {
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 商户号
     */
    private String merchantId;
    /**
     * 身份证号
     */
    private String idCardNum;
    /**
     * 这是姓名
     */
    private String realName;
    /**
     * 主题id
     */
    private Integer themeId;
    /**
     * 主题名称
     */
    private String themeName;
    /**
     * 查询的用户类型
     */
    private Integer themePrice;

    /**
     * 推荐人id
     */
    private String referrer;
    /**
     * 推荐人姓名
     */
    private String referrerName;
    /**
     * 推荐人电话
     */
    private String referrerPhone;
    /**
     * 二维码短连接
     */
    private String qrCodeUrl;
    /**
     * 邀请码
     */
    private String activityCode;
    /**
     * 活动Id
     */
    private Integer activityId;
    /**
     * 是否使用
     */
    private Integer isUsed;
    /**
     * 是否使用
     */
    private Integer sendMsg;
    /**
     * 记录
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
}
