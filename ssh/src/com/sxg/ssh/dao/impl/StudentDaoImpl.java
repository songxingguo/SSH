package com.sxg.ssh.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sxg.ssh.dao.StudentDao;
import com.sxg.ssh.domain.Student;
import com.sxg.ssh.domain.Class;
import com.sxg.ssh.dto.StudentDTO;
import com.sxg.ssh.utils.HibernateUtils;
import com.sxg.ssh.utils.StringUtil;

/**
 * 
 * @author Administrator
 */
@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired 
	private HibernateTemplate hibernateTemplate;
	
	public Student findByUsernameAndPassword(StudentDTO stuDTO) {
		String loginHql = "FROM Student s WHERE s.username= ? and s.password= ?";
		
		List<?> stus = hibernateTemplate.find(loginHql, 
				stuDTO.getUsername(), stuDTO.getPassword());

		if (stus.size() > 0) {
			return (Student) stus.get(0);
		}
	
		return null;
	}

	@Override
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveStudent(Student stu) {
		//得到session
		Session session = HibernateUtils.getSession();
		//开启事务
		session.beginTransaction();
		session.save(stu); //持久化状态
		
		//提交事务
		session.getTransaction().commit();
		
		//关闭资源
		session.close();
	}
	
	@Override
	public void deleteStudent(String id) {
		Session session= HibernateUtils.getSession();
        //开启事务.
        session.beginTransaction();
        //采用load查询不存在的数据,hibernate会抛出object not found exception
        Student stu = (Student)session.load(Student.class, id);
        
        Class clas =(Class)session.load(Class.class, stu.getCla());
        clas.getStus().remove(stu);
        
        session.delete(stu);
        
        //提交事务.把内存的改变提交到数据库上.
        session.getTransaction().commit();
	}
	
	@Override
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateStudent(Student stu) {
		//得到session
		Session session = HibernateUtils.getSession();
		//开启事务
		session.beginTransaction();
		session.update(stu); //持久化状态
		
		//提交事务
		session.getTransaction().commit();
		
		//关闭资源
		session.close();
	}
	
	@Override
	public List<Student> findByCon(StudentDTO stuDTO) {
		
		StringBuffer stusHql = new StringBuffer("FROM Student");
		
		if (!StringUtil.isNullOrEmpty(stuDTO.getcNo())) {
			stusHql.append(" LEFT JOIN class ON student.cid = class.cid " +
					"AND class.cNo LIKE '%" + stuDTO.getcNo() +"%'");
		}
		
		if (StringUtil.isNullOrEmptyForMultiStr(stuDTO.getProName(), 
				stuDTO.getProValue(), stuDTO.getOperate())) {
			return (List<Student>)hibernateTemplate.find(stusHql.toString());
		}
		
		stusHql.append("WHERE 1 = 1");
		
		if (stuDTO.getOperate().equals("%")) {
			
			stusHql.append(" AND " + stuDTO.getProName() + 
					" LIKE '%" + stuDTO.getProValue() +"%'");	
		} else {
			stusHql.append(" AND " + stuDTO.getProName() + 
					stuDTO.getOperate() + "'" + stuDTO.getProValue() +"'");	
		}
				
		return (List<Student>)hibernateTemplate.find(stusHql.toString());
	}

	@Override
	public Student getStudentById(String id) {
		return hibernateTemplate.get(Student.class, id);
	}
}
