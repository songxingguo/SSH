package com.sxg.ssh.service;

import java.util.List;

import com.sxg.ssh.domain.Student;
import com.sxg.ssh.dto.StudentDTO;

/**
 * 
 * @author songxingguo
 * @date 2017.10.27
 */
public interface StudentService {
	
	/**
	 * 学生登录
	 * @param stu
	 * @return
	 */
	Student login(StudentDTO stuDTO);
	
	/**
	 * 学生新增
	 * @param stuDTO
	 */
	void saveStudent(StudentDTO stuDTO);
	
	/**
	 * 学生删除
	 * @param id
	 * @return
	 */
	void deleteStudent(String id);
	
	/**
	 * 学生编辑
	 * @param stuDTO
	 */
	void updateStudent(StudentDTO stuDTO);
	
	/**
	 * 根据条件查找学生
	 * @param stuDTO
	 * @return
	 */
	List<Student> findStudents(StudentDTO stuDTO);
	
	/**
	 * 获取学生总数
	 * @param stuDTO
	 * @return
	 */
	int getStudentsCount();
	
	/**
	 * 根据id获取学生
	 * @param id
	 * @return
	 */
	Student getStudentById(String id);
}
