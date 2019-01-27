package com.zwl.userCertificationManager.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-19 11:26:46
 */
public class SaasUserCertificationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//真实姓名
	private String realName;
	//身份证
	private String idCardNum;
	//手机号
	private String phone;
	//
	private String userId;
	//商户所属id
	private String merchantId;
	//性别
	private String sex;
	//城市
	private String city;
	//职业
	private String profession;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//
	private Integer available;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
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
	 * 设置：身份证
	 */
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdCardNum() {
		return idCardNum;
	}
	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：商户所属id
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * 获取：商户所属id
	 */
	public String getMerchantId() {
		return merchantId;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：职业
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * 获取：职业
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：
	 */
	public void setAvailable(Integer available) {
		this.available = available;
	}
	/**
	 * 获取：
	 */
	public Integer getAvailable() {
		return available;
	}
}
