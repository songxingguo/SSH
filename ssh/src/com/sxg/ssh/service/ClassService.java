package com.sxg.ssh.service;

import java.util.List;

import com.sxg.ssh.domain.Class;
import com.sxg.ssh.dto.ClassDTO;

public interface ClassService {

	/**
	 * 新增班级
	 * @param claDTO
	 */
	void saveClass(ClassDTO claDTO);
	
	/**
	 * 删除学生
	 * @param id
	 */
	void deleteClass(String id);
	
	/**
	 * 根据条件查询班级
	 * @param claDTO
	 * @return
	 */
	List<Class> findClas(ClassDTO claDTO);
	
	/**
	 * 根据id获取班级
	 * @param id
	 * @return
	 */
	Class getClaById(String id);
}
