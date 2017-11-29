package com.sxg.ssh.dao;

import java.util.List;

import com.sxg.ssh.domain.Student;
import com.sxg.ssh.dto.StudentDTO;

/**
 * 
 * @author songxingguo
 * @date 2017.10.27
 */
public interface StudentDao {
	
	/**
	 * 登录
	 * @param stuDTO
	 * @return
	 */
	Student findByUsernameAndPassword(StudentDTO stuDTO);
	

	/**
	 * 新增学生
	 * @param stuDTO
	 * @return
	 */
	void saveStudent(Student stu);
	
	/**
	 * 删除学生
	 * @param id
	 */
	void deleteStudent(String id);
	
	/**
	 * 修改学生
	 * @param id
	 */
	void updateStudent(Student stu);
	
	/**
	 * 根据条件查找学生
	 * @param stuDTO
	 * @return
	 */
	List<Student> findByCon(StudentDTO stuDTO);
	
	/**
	 * 根据id获取学生
	 * @param id
	 * @return
	 */
	Student getStudentById(String id);
}
