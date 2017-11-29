package com.sxg.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxg.ssh.dao.ClassDao;
import com.sxg.ssh.dto.ClassDTO;
import com.sxg.ssh.service.ClassService;
import com.sxg.ssh.domain.Class;

/**
 * 
 * @author songxingguo
 * @Date 2017年11月2日
 */
@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDao classDao;
	
	@Override
	public void saveClass(ClassDTO claDTO) {
		classDao.saveClass(claDTO);
	}
	
	@Override
	public void deleteClass(String id) {
		classDao.deleteClass(id);
	}
	
	@Override
	public List<Class> findClas(ClassDTO claDTO) {
		return classDao.findClas(claDTO);
	}

	@Override
	public Class getClaById(String id) {
		return classDao.getClas(id);
	}
}
