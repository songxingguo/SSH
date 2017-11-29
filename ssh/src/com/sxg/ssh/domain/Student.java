package com.sxg.ssh.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author songxingguo
 * @date 2017.10.27
 */
@Entity
@Table(name="student")
public class Student {
	
    @Id              
    @GeneratedValue(generator = "studentGenerator")    
    @GenericGenerator(name = "studentGenerator", strategy = "assigned") 
	private String sid;
    
    @Column(name = "stuNo", length=20)
	private String stuNo;
    
    @Column(name = "stuName", length=20)
	private String stuName;
    
    @Column(name = "stuAge", length=3)
	private Integer stuAge;
    
    @Column(name = "username", length=20)
	private String username;
    
    @Column(name = "password", length=20)
	private String password;
    
    @ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="cid")
    private Class cla;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Class getCla() {
		return cla;
	}
	public void setCla(Class cla) {
		this.cla = cla;
	}
//	public String getCid() {
//		return cid;
//	}
//	public void setCid(String cid) {
//		this.cid = cid;
//	}
}
