package com.ems.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EmployeeHSBC {
	
	@Id
	@SequenceGenerator(name="my_seq", sequenceName="account_user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="my_seq")
	private int    EmployeeNo;
	private String EmployeeName;
	private String Nationality;
	private int    national_ID_NUM;
	private String role;
	private String department;
	private String lineManager;
	private String emailAddress;
	private String mobileNo;
	
	public EmployeeHSBC(int employeeNo) {
		super();
		EmployeeNo = employeeNo;
	}

	public EmployeeHSBC() {
		super();
	}

	public EmployeeHSBC(String employeeName, String nationality, int national_ID_NUM, String role, String department,
			String lineManager, String emailAddress, String mobileNo) {
		
		EmployeeName = employeeName;
		Nationality = nationality;
		this.national_ID_NUM = national_ID_NUM;
		this.role = role;
		this.department = department;
		this.lineManager = lineManager;
		this.emailAddress = emailAddress;
		this.mobileNo = mobileNo;
	}
	
	public int getEmployeeNo() {
		return EmployeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		EmployeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public int getNational_ID_NUM() {
		return national_ID_NUM;
	}
	public void setNational_ID_NUM(int national_ID_NUM) {
		this.national_ID_NUM = national_ID_NUM;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLineManager() {
		return lineManager;
	}
	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	
	
}
