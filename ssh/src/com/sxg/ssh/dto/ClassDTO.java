package com.sxg.ssh.dto;

import com.sxg.ssh.domain.Class;
import com.sxg.ssh.utils.StringUtil;

public class ClassDTO {

	private String cid;
	
	private String claId;
	
	private String cNo;

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

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	
	/**
	 * 转换为实体
	 */
	public Class toClass() {
		Class cla = new Class();
		
		cla.setCid(StringUtil.createTimestamp());
		cla.setClaId(claId);
		cla.setcNo(cNo);
		
		return cla;
	}
}
