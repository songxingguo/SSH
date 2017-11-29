package com.sxg.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxg.ssh.dao.StudentDao;
import com.sxg.ssh.domain.Class;
import com.sxg.ssh.domain.Student;
import com.sxg.ssh.dto.StudentDTO;
import com.sxg.ssh.service.ClassService;
import com.sxg.ssh.service.StudentService;

/**
 * 
 * @author songxingguo
 * @date 2017.10.27
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ClassService classService;
	
	@Override
	public Student login(StudentDTO stuDTO) {
		return studentDao.findByUsernameAndPassword(stuDTO);
	}

	@Override
	public void saveStudent(StudentDTO stuDTO) {
		Class cla = classService.getClaById(stuDTO.getCid());
		
		Student stu = stuDTO.toStudent();
		stu.setCla(cla);
		cla.getStus().add(stu);
		studentDao.saveStudent(stu);
	};
	
	@Override
	public void deleteStudent(String id) {
		studentDao.deleteStudent(id);
	}

	@Override
	public void updateStudent(StudentDTO stuDTO) {
		studentDao.updateStudent(stuDTO.toStudent());
	}

	@Override
	public List<Student> findStudents(StudentDTO stuDTO) {
		return studentDao.findByCon(stuDTO);
	}

	@Override
	public int getStudentsCount() {
		
		StudentDTO stuDTO = new StudentDTO();
		return studentDao.findByCon(stuDTO).size();
	}
	
	@Override
	public Student getStudentById(String id) {
		return studentDao.getStudentById(id);
	}
}
