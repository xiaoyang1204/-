package com.juyi.model;

import java.io.Serializable;

/**
 * 婚宴
 * @author Admin
 *
 */
public class Wedding implements Serializable{
	
	/**
	 * 序列化标识符
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 婚宴预约人数id
	 */
	private Integer weddingId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 婚期
	 */
	private String dataTime;
	/**
	 * 婚礼场景
	 */
	private String scene;
	/**
	 * 婚礼风格
	 */
	private String style;
	/**
	 * 婚礼预算
	 */
	private String budget;
	/**
	 * 预约人是手机号
	 */
	private String phone;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 录入时间
	 */
	private String inputTime;
	
	/**
	 * GET/SET方法
	 * @return
	 */
	public Integer getWeddingId() {
		return weddingId;
	}
	public void setWeddingId(Integer weddingId) {
		this.weddingId = weddingId;
	}
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDataTime() {
		return dataTime;
	}
	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}
	public String getInputTime() {
		return inputTime;
	}
	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Wedding [weddingId=" + weddingId + ", name=" + name + ", city=" + city + ", dataTime=" + dataTime
				+ ", scene=" + scene + ", style=" + style + ", budget=" + budget + ", phone=" + phone + ", inputTime="
				+ inputTime + "]";
	}
	
}
