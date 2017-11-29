package com.sxg.ssh.dao;

import java.util.List;

import com.sxg.ssh.dto.ClassDTO;
import com.sxg.ssh.domain.Class;

public interface ClassDao {

	/**
	 * 新增班级
	 * @param claDTO
	 */
	void saveClass(ClassDTO claDTO);
	
	/**
	 * 删除班级
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
	Class getClas(String id);
}
