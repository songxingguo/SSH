package com.sxg.ssh.dto;

import java.util.List;

import com.sxg.ssh.domain.Class;
import com.sxg.ssh.domain.Student;
import com.sxg.ssh.utils.StringUtil;

/**
 * 
 * @author songxingguo
 * @date 2017.10.27
 */
public class StudentDTO {
	
	private String sid;
    
	private String stuNo;
    
	private String stuName;
    
	private Integer stuAge;
    
	private String username;
    
	private String password;
	
	private String cid;
	
	//属性
	private String proName;
	
	//操作
	private String operate;
	
	//属性值ֵ
	private String proValue;
	
	private Integer first;
	
	private Integer max;
	
	private List<Class> clas;
	
	private String cNo;
	
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
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getProValue() {
		return proValue;
	}
	public void setProValue(String proValue) {
		this.proValue = proValue;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public List<Class> getClas() {
		return clas;
	}
	public void setClas(List<Class> clas) {
		this.clas = clas;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	
	/**
	 * 转换为实体
	 * @return
	 */
	public Student toStudent() {
		Student stu = new Student();
		
		stu.setSid(StringUtil.createTimestamp());
		stu.setPassword(password);
		stu.setStuAge(stuAge);
		stu.setStuName(stuName);
		stu.setStuNo(stuNo);
		stu.setUsername(username);

		return stu;
	}
}
