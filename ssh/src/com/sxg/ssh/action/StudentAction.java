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
import com.sxg.ssh.domain.Class;
import com.sxg.ssh.domain.Student;
import com.sxg.ssh.dto.ClassDTO;
import com.sxg.ssh.dto.StudentDTO;
import com.sxg.ssh.service.ClassService;
import com.sxg.ssh.service.StudentService;


/**
 * 
 * @author songxingguo
 * @date 2017.10.27
 */
@ParentPackage("ssh")  
@Controller
@Result(name="stus", type="chain", location="stus")
public class StudentAction extends ActionSupport 
	implements ModelDriven<StudentDTO> {
	
	private static final long serialVersionUID = 1L;
	
	private  StudentDTO stuDTO = new StudentDTO();
	@Override
	public StudentDTO getModel() {
		return stuDTO;
	}
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassService classService;
	
	/**
	 * 学生新增
	 * @return
	 */
	@Action(value="/stuAdd")
	public String saveStudent() {
		
		studentService.saveStudent(stuDTO);
			
		return "stus";
	}
	
	/**
	 * 学生删除
	 * @return
	 */
	@Action(value="/stuDelete")
	public String deleteStudent() {
		
		studentService.deleteStudent(stuDTO.getSid());
		return "stus";
	}
	
	/**
	 * 学生编辑
	 * @return
	 */
	@Action(value="/stuEdit")
	public String updateStudent() {
		
		studentService.updateStudent(stuDTO);
			
		return "stus";
	}
	
	@Action(value="/stus", results={@Result(name="stus", 
			location="/front/stuInfo/student.jsp")})
	public String findStudents() {
		
		List<Student> stus = studentService.findStudents(stuDTO);
		
		ActionContext.getContext().getValueStack().set("stuCount", studentService.getStudentsCount());
		ActionContext.getContext().getValueStack().set("stus", stus);
		
		//添加班级
		ActionContext.getContext().getValueStack().set("clas", classService
				.findClas(new ClassDTO()));
		
		return "stus";
	}

	@Action(value="/stu", results={@Result(name="stu", type="chain",
			location="/front/stuInfo/studentEdit.jsp")})
	public String getStudent() {
		
		Student stu = studentService.getStudentById(stuDTO.getSid());
		ActionContext.getContext().getValueStack().set("stu", stu);
		
		return "stu";
	}

	@Action(value="/addStu", results={@Result(name="clas",
			location="/front/stuInfo/studentAdd.jsp")})
	public String addStu() {
		ClassDTO claDTO = new ClassDTO();
		List<Class> clas = classService.findClas(claDTO);
		ActionContext.getContext().getValueStack().set("clas", clas);
		return "clas";
	}
	
	@Action(value="/editStu", results={@Result(name="clas",
			location="/front/stuInfo/studentEdit.jsp")})
	public String editStu() {
		ClassDTO claDTO = new ClassDTO();
		List<Class> clas = classService.findClas(claDTO);
		ActionContext.getContext().getValueStack().set("clas", clas);
		
		Student stu = studentService.getStudentById(stuDTO.getSid());
		ActionContext.getContext().getValueStack().set("stu", stu);
		return "clas";
	}
}
