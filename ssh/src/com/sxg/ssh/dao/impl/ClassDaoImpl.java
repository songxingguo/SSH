package com.sxg.ssh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sxg.ssh.dao.ClassDao;
import com.sxg.ssh.domain.Class;
import com.sxg.ssh.dto.ClassDTO;
import com.sxg.ssh.utils.HibernateUtils;

/**
 * 
 * @author songxingguo
 * @date 2017.11.1
 */
@Repository
public class ClassDaoImpl implements ClassDao {

	@Autowired 
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveClass(ClassDTO claDTO) {
		//得到session
		Session session = HibernateUtils.getSession();
		//开启事务
		session.beginTransaction();
		session.save(claDTO.toClass()); //持久化状态
		
		//提交事务
		session.getTransaction().commit();
		
		//关闭资源
		session.close();
	}
	
	@Override
	public void deleteClass(String id) {
		Session session= HibernateUtils.getSession();
        //开启事务.
        session.beginTransaction();
        //采用load查询不存在的数据,hibernate会抛出object not found exception
        Class cla = (Class)session.load(Class.class, id);
        
        session.delete(cla);
        
        //提交事务.把内存的改变提交到数据库上.
        session.getTransaction().commit();
	}
	
	@Override
	public List<Class> findClas(ClassDTO claDTO) {
		StringBuffer clasHql = new StringBuffer("FROM Class WHERE 1 = 1");
		
		return (List<Class>)hibernateTemplate.find(clasHql.toString());
	}

	@Override
	public Class getClas(String id) {
		return hibernateTemplate.get(Class.class, id);
	}
}
