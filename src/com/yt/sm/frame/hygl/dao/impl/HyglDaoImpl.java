package com.yt.sm.frame.hygl.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.yt.sm.frame.hygl.dao.HyglDao;
import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public class HyglDaoImpl implements HyglDao {
	private Logger logger = Logger.getLogger(HyglDaoImpl.class);
	protected SqlSessionTemplate sqlTemplate;
	public SqlSessionTemplate getSqlTemplate() {
		return sqlTemplate;
	}
	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}
	@Override
	public int addPerson(Map<String, Object> map) {
		return sqlTemplate.insert("hyglMapper.addPerson", map);
	}
	@Override
	public int updatePerson(Map<String, Object> map) {
		return sqlTemplate.update("hyglMapper.updatePerson", map);
	}
	@Override
	public List<Menu> findAdminMenu(Map<String, Object> map) {
		return sqlTemplate.selectList("hyglMapper.findAdminMenu", map);
	}
	@Override
	public User getOneUser(Map<String, Object> map) {
		return sqlTemplate.selectOne("hyglMapper.getOneUser", map);
	}
	@Override
	public int savePwd(Map<String, Object> map) {
		return sqlTemplate.update("hyglMapper.savePwd", map);
	}
	@Override
	public Person getPersonInfo(Map<String, Object> map) {
		return sqlTemplate.selectOne("hyglMapper.getPersonInfo", map);
	}
	@Override
	public Group getGroupInfo(Map<String, Object> map) {
		return sqlTemplate.selectOne("hyglMapper.getGroupInfo", map);
	}
	@Override
	public int updateGroup(Map<String, Object> map) {
		return sqlTemplate.update("hyglMapper.updateGroup", map);
	}
	@Override
	public int getPersonTotal(Map<String, Object> map) {
		return sqlTemplate.selectOne("hyglMapper.getPersonTotal", map);
	}
	@Override
	public List<Person> findPersonList(Map<String, Object> map) {
		return sqlTemplate.selectList("hyglMapper.findPersonList", map);
	}
	@Override
	public int delPerson(Map<String, Object> map) {
		return sqlTemplate.delete("hyglMapper.delPerson", map);
	}
	@Override
	public List<Group> findGroupList(Map<String, Object> map) {
		return sqlTemplate.selectList("hyglMapper.findGroupList", map);
	}
	@Override
	public int getGroupTotal(Map<String, Object> map) {
		return sqlTemplate.selectOne("hyglMapper.getGroupTotal", map);
	}
	@Override
	public int delGroup(Map<String, Object> map) {
		return sqlTemplate.delete("hyglMapper.delGroup", map);
	}
	@Override
	public List<Person> findPersonList2(Map<String, Object> map1) {
		return sqlTemplate.selectList("hyglMapper.findPersonList2", map1);
	}
	@Override
	public List<Group> findGroupList2(Map<String, Object> map1) {
		return sqlTemplate.selectList("hyglMapper.findGroupList2", map1);
	}
	@Override
	public int getGroupMax(Map<String, Object> map) {
		return sqlTemplate.selectOne("hyglMapper.getGroupMax", map);
	}
	@Override
	public int getPersonMax(Map<String, Object> map) {
		return sqlTemplate.selectOne("hyglMapper.getPersonMax", map);
	}
}
