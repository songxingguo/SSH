package com.sxg.ssh.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sxg.ssh.domain.Student;
import com.sxg.ssh.dto.StudentDTO;
import com.sxg.ssh.service.StudentService;

@ParentPackage("struts-default")  
@Controller
public class LoginAction extends ActionSupport 
	implements ModelDriven<StudentDTO> {
	
	private static final long serialVersionUID = 1L;
	
	//��װ����
	private  StudentDTO stuDTO = new StudentDTO();
	@Override
	public StudentDTO getModel() {
		return stuDTO;
	}
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * 登录
	 * @param stu
	 * @return
	 */
	@Action(value="/login", results={@Result(name="index", 
			location="/index.jsp"),
			@Result(name="input", 
			location="/login.jsp")})
	public String login() {
		
		Student existStu = studentService.login(stuDTO);
		
		if (existStu == null) {
			this.addActionError("账号或密码错误！");
			
			return INPUT;
		} else {
			
			List<Student> stus = studentService.findStudents(stuDTO);
			ActionContext.getContext().getValueStack().set("stus", stus);
			
			ActionContext.getContext().getSession().put("stu", existStu);
			return "index";
		}
	}
}
