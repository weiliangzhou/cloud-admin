package com.zwl.activateInfoManager.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-13 18:10:09
 */

public class SaasActivateInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//商户号
	private String merchantId;
	//手机号
	private String phone;
	//
	private String realName;
	//活动主题id
	private Integer themeId;
	//活动主题名称
	private String themeName;
	//主题价格
	private Integer themePrice;
	//推荐人id
	private String referrer;
	//推荐人姓名
	private String referrerName;
	//推荐人手机号
	private String referrerPhone;
	//城市id
	private Integer activityId;
	//0未使用 1已使用
	private Integer isUsed;
	//二维码短连接
	private String qrCodeUrl;
	//邀请码
	private String activityCode;
	//记录
	private String remark;
	//0:未发送；1：发送未成功；2：发送成功
	private String sendMsg;
	//身份证号
	private String idCardNum;



	//创建时间
	private Date createTime;

	public String getQrCodeUrl() {
		return qrCodeUrl;
	}

	public void setQrCodeUrl(String qrCodeUrl) {
		this.qrCodeUrl = qrCodeUrl;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：商户号
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * 获取：商户号
	 */
	public String getMerchantId() {
		return merchantId;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：活动主题id
	 */
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	/**
	 * 获取：活动主题id
	 */
	public Integer getThemeId() {
		return themeId;
	}
	/**
	 * 设置：活动主题名称
	 */
	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	/**
	 * 获取：活动主题名称
	 */
	public String getThemeName() {
		return themeName;
	}
	/**
	 * 设置：主题价格
	 */
	public void setThemePrice(Integer themePrice) {
		this.themePrice = themePrice;
	}
	/**
	 * 获取：主题价格
	 */
	public Integer getThemePrice() {
		return themePrice;
	}
	/**
	 * 设置：推荐人id
	 */
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	/**
	 * 获取：推荐人id
	 */
	public String getReferrer() {
		return referrer;
	}
	/**
	 * 设置：推荐人姓名
	 */
	public void setReferrerName(String referrerName) {
		this.referrerName = referrerName;
	}
	/**
	 * 获取：推荐人姓名
	 */
	public String getReferrerName() {
		return referrerName;
	}
	/**
	 * 设置：推荐人手机号
	 */
	public void setReferrerPhone(String referrerPhone) {
		this.referrerPhone = referrerPhone;
	}
	/**
	 * 获取：推荐人手机号
	 */
	public String getReferrerPhone() {
		return referrerPhone;
	}
	/**
	 * 设置：城市id
	 */
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	/**
	 * 获取：城市id
	 */
	public Integer getActivityId() {
		return activityId;
	}
	/**
	 * 设置：0未使用 1已使用
	 */
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	/**
	 * 获取：0未使用 1已使用
	 */
	public Integer getIsUsed() {
		return isUsed;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
