package com.juyi.model;

import java.io.Serializable;
/**
 * User类
 * @author Admin
 *
 */
public class User implements Serializable{

	/**
	 * 序列化标识符
	 */
	private static final long serialVersionUID = 1L;
	private Integer uid;			//用户id
	private String name;			//用户名称
	private String tel;				//用户电话
	private String course;			//所选择的课程
	private String province;		//所在身份
	private String city;			//所在地区
	private String area;			//所在城市
	private String type;			//类型
	private String dateTime;		//创建时间
	
	//get/set构造
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//无参构造
	public User() {
		super();
	}
	//有参构造
	public User(Integer uid, String name, String tel, String course, String province, String city, String area,
			String type, String dateTime) {
		super();
		this.uid = uid;
		this.name = name;
		this.tel = tel;
		this.course = course;
		this.province = province;
		this.city = city;
		this.area = area;
		this.type = type;
		this.dateTime = dateTime;
	}
}
