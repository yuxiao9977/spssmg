package com.yt.sm.frame.impData.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.impData.dao.ImpDataDao;

public class ImpDataDaoImpl implements ImpDataDao {
	protected SqlSessionTemplate sqlTemplate;

	public SqlSessionTemplate getSqlTemplate() {
		return sqlTemplate;
	}

	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}

	@Override
	public int addPerson(Map<String, Object> map) {
		return sqlTemplate.insert("impDataMapper.addPerson", map);
	}

	@Override
	public List<Person> findPersonList(Map<String, Object> map) {
		
		return sqlTemplate.selectList("impDataMapper.findPersonList", map);
	}

	@Override
	public int addGroup(Map<String, Object> map) {
		return sqlTemplate.insert("impDataMapper.addGroup", map);
	}

	@Override
	public List<Group> findGroupList(Map<String, Object> map) {
		return sqlTemplate.selectList("impDataMapper.findGroupList", map);
	}
	
}
