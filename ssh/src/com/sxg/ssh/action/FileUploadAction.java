package com.sxg.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("ssh")  
@Controller
public class FileUploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private File file;
	
	private String fileFileName;
	
	private String fileContentType;
	
	@Action(value="/fileUpload", results={@Result(name="fileUpload", 
			location="/front/stuInfo/student.jsp")})
	public String fileUpload() throws Exception{
	   	
		InputStream is = new FileInputStream(file);
		
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath("/uploadFile");
		
		File toFile = new File(uploadPath, this.getFileFileName());
		
		OutputStream os = new FileOutputStream(toFile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while (-1 != (length=is.read(buffer, 0, buffer.length))) {
			os.write(buffer);
		}
		
		is.close();
		os.close();
		
		return "fileUpload";
	}
	
	@Action(value="/excleUpload", results={@Result(name="excleUpload", 
			location="/front/file/fileUpload.jsp")})
	public String excleUpload() throws Exception{
		return "excleUpload";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}	
}
