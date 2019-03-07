package com.juyi.model;

import java.io.Serializable;

/**
 * 学员表
 * @author Admin
 *
 */
public class Student implements Serializable{

	/**
	 * 序列化标识符
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 学员id
	 */
	private Integer sId;
	/**
	 * 学员姓名
	 */
	private String StudentName;
	/**
	 * 培训课程
	 */
	private String curriculum;
	/**
	 * 证书编号
	 */
	private String CertificateNumber;
	/**
	 * 证书证明
	 */
	private String certificate;
	/**
	 * 培训时间
	 */
	private String trainingTime;
	/**
	 * 认证时间
	 */
	private String certificationDate;
	/**
	 * 身份证号
	 */
	private String IDNumber;
	/**
	 * 学院网址
	 */
	private String school;
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public String getCertificateNumber() {
		return CertificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		CertificateNumber = certificateNumber;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getTrainingTime() {
		return trainingTime;
	}
	public void setTrainingTime(String trainingTime) {
		this.trainingTime = trainingTime;
	}
	public String getCertificationDate() {
		return certificationDate;
	}
	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", StudentName=" + StudentName + ", curriculum=" + curriculum + ", CertificateNumber="
				+ CertificateNumber + ", certificate=" + certificate + ", trainingTime=" + trainingTime
				+ ", certificationDate=" + certificationDate + ", IDNumber=" + IDNumber + ", school=" + school + "]";
	}
	
	
	
	
	public Student() {
		super();
	}
	
	public Student(Integer sId, String StudentName, String curriculum, String certificateNumber, String certificate,
			String trainingTime, String certificationDate, String iDNumber, String school) {
		super();
		this.sId = sId;
		this.StudentName = StudentName;
		this.curriculum = curriculum;
		CertificateNumber = certificateNumber;
		this.certificate = certificate;
		this.trainingTime = trainingTime;
		this.certificationDate = certificationDate;
		IDNumber = iDNumber;
		this.school = school;
	}
	
	
}
