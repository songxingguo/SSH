package com.sxg.ssh.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import sun.misc.BASE64Encoder;


/**
 * 
 * @author songxingguo
 * @date 2017.11.4
 */
@ParentPackage("ssh")  
@Controller
public class DownLoadAtion extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String filename;
	private String contentType;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	

	public String getContentType() {
		return ServletActionContext.getServletContext()
				.getMimeType(filename);
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	

	public InputStream getInputStream() throws IOException {
		
		String filePath = "/uploadFile/" + filename;
		return ServletActionContext.getServletContext()
				.getResourceAsStream(filePath);
	}
	
	@Action(value="/downLoad", results={@Result(name="downLoad", 
			type="stream", params={"contentType", "${contentType}", 
					"contentDispostion", "attachment;filename=${filename}",
					"inputName", "inputStream"},
			location="/front/stuInfo/student.jsp")})
	public String downLoad() {
		return "downLoad";
	}
	
	public String encodeDownloadFilename(String name, String agent) throws UnsupportedEncodingException {
		if (agent.contains("Firefox")) {
			name = "=?UTF-8?B?" 
					+ new BASE64Encoder().encode(name.getBytes("utf-8")) + "?=";
		} else {
			name = URLEncoder.encode(name, "utf-8");
		}
		
		return name;
	}
}
