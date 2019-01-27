package com.zwl.offlineActivityManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class OfflineActivityOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private String orderNo;
	//线下活动id
	private Integer activityId;
	//主题id
	private Integer activityThemeId;
	//活动消费码
	private String activityCode;
	//活动费用
	private Integer activityPrice;
	//实际支付金额
	private Integer actualMoney;
	//0待支付 1支付成功 -1超时
	private Integer orderStatus;
	//
	private String userId;
	//0男 1女
	private Integer sex;
	//手机号
	private String phone;
	//真实姓名
	private String realName;
	//所在城市
	private String city;
	//身份证号码
	private String idCardNum;
	//支付流水号
	private String paymentNo;
	//支付时间
	private Date paymentTime;
	//商户号
	private String merchantId;
	//是否返佣，0不返佣，1返佣
	private Integer isMaid;
	//是否复训 0不是1是
	private Integer isRetraining;
	//职业 : 0品牌商  1团队长  2创业者
	private Integer profession;
	//推荐人
	private String referrer;
	//业务员手机号
	private String referrerPhone;
	//业务员
	private String referrerName;
	//122334
	private String remark;
	//
	private Integer changeTimes;
	//活动开始时间
	private Date startTime;
	//活动结束时间
	private Date endTime;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//
	private Integer available;
	//开课城市
	private String activityAddress;
	//线下课程主题
	private String themeName;
	//订单课程状态
	private Integer isUsed;
}
