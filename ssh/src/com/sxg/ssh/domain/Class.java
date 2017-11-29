package com.sxg.ssh.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="class")
public class Class implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id              
    @GeneratedValue(generator = "classGenerator")    
    @GenericGenerator(name = "classGenerator", strategy = "assigned") 
	private String cid;
	
    @Column(name = "claId", length=20)
	private String claId;
	
    @Column(name = "cNo", length=20)
	private String cNo;
    
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy = "cla")
    private Set<Student> stus;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getClaId() {
		return claId;
	}

	public void setClaId(String claId) {
		this.claId = claId;
	}

	public Set<Student> getStus() {
		return stus;
	}

	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
}
