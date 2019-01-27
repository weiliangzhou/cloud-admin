package com.zwl.user.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户基本信息表
 *
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-26 10:24:57
 */
@Data
public class SaasUserInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userId;
    /**
     * 第一次注册手机号，用来登录 （与user_name、binding_mobile一致）
     */
    private String registerMobile;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 用户昵称，用于小程序显示
     */
    private String nickName;
    /**
     * 用户头像
     */
    private String logoUrl;
    /**
     * 微信号码
     */
    private String wechatNo;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 逻辑删除
     */
    private Integer available;

}
