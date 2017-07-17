package com.yt.sm.frame.dlzc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.yt.sm.frame.dlzc.dao.DlzcDao;
import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public class DlzcDaoImpl implements DlzcDao {
	private Logger logger = Logger.getLogger(DlzcDaoImpl.class);
	protected SqlSessionTemplate sqlTemplate;
	public SqlSessionTemplate getSqlTemplate() {
		return sqlTemplate;
	}
	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}
	@Override
	public List<User> getUserByname(Map<String, Object> map) {
		return sqlTemplate.selectList("dlzcMapper.getUserByname", map);
	}
	@Override
	public int addPerson(Map<String, Object> map) {
		return sqlTemplate.insert("dlzcMapper.addPerson", map);
	}
	@Override
	public List<Person> findPersonList(Map<String, Object> map) {
		return sqlTemplate.selectList("dlzcMapper.findPersonList", map);
	}
	@Override
	public int addUser(Map<String, Object> map) {
		return sqlTemplate.insert("dlzcMapper.addUser", map);
	}
	@Override
	public int addGroup(Map<String, Object> map) {
		return sqlTemplate.insert("dlzcMapper.addGroup", map);
	}
	@Override
	public List<Group> findGroupList(Map<String, Object> map) {
		return sqlTemplate.selectList("dlzcMapper.findGroupList", map);
	}
	@Override
	public int deleteUser(Map<String, Object> map) {
		return sqlTemplate.delete("dlzcMapper.deleteUser", map);
	}
	@Override
	public User getOneUser2(Map<String, Object> map) {
		return sqlTemplate.selectOne("dlzcMapper.getOneUser2", map);
	}
	@Override
	public int updateUser(Map<String, Object> map) {
		return sqlTemplate.update("dlzcMapper.updateUser", map);
	}
	
}
