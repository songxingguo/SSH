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
import com.sxg.ssh.dto.ClassDTO;
import com.sxg.ssh.service.ClassService;

/**
 * 
 * @author songxingguo
 * @date 2017.11.4
 */
@ParentPackage("ssh")  
@Controller
@Result(name="clas", type="chain", location="clas")
public class ClassAction extends ActionSupport 
	implements ModelDriven<ClassDTO> {
	
	private static final long serialVersionUID = 1L;
	private  ClassDTO claDTO = new ClassDTO();
	
	@Override
	public ClassDTO getModel() {
		return claDTO;
	}
	
	@Autowired
	private ClassService classService;
	
	/**
	 * 新增班级
	 * @return
	 */
	@Action(value="/classAdd")
	public String saveClass() {
		
		classService.saveClass(claDTO);
		return "clas";
	}
	
	/**
	 * 删除班级
	 * @return
	 */
	@Action(value="/classDelete")
	public String deleteClass() {
		
		classService.deleteClass(claDTO.getCid());
		return "clas";
	}
	
	/**
	 * 修改班级
	 * @return
	 */
	@Action(value="/classUpdate")
	public String updateClass() {
		
		classService.saveClass(claDTO);
		return "clas";
	}
	
	/**
	 * 根据条件查找班级
	 * @return
	 */
	@Action(value="/clas", results={@Result(name="clas", 
			location="/front/class/class.jsp")})
	public String findClas() {
		
		List<Class> clas = classService.findClas(claDTO);
		ActionContext.getContext().getValueStack().set("clas", clas);
		return "clas";
	}
	
	/**
	 * 根据id获取班级
	 * @return
	 */
	@Action(value="/cla", results={@Result(name="cla", 
			location="/front/class/class.jsp")})
	public String getClaById() {
		
		Class cla = classService.getClaById(claDTO.getCid());
		ActionContext.getContext().getValueStack().set("cla", cla);
		return "cla";
	}
}
