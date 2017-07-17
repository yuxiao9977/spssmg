package com.yt.sm.frame.attach.dao.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.yt.sm.frame.attach.dao.AttachDao;
import com.yt.sm.frame.attach.vo.Attach;

public class AttachDaoImpl implements AttachDao {
	private Logger logger = Logger.getLogger(AttachDaoImpl.class);
	protected SqlSessionTemplate sqlTemplate;
	public SqlSessionTemplate getSqlTemplate() {
		return sqlTemplate;
	}
	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}
	@Override
	public int addAttach(Map<String, Object> map) {
		return sqlTemplate.insert("attachMapper.addAttach", map);
	}
	@Override
	public Attach getOneAttach(Map<String, Object> map) {
		return sqlTemplate.selectOne("attachMapper.getOneAttach", map);
	}
	@Override
	public Attach findAttach(Map<String, Object> map) {
		return sqlTemplate.selectOne("attachMapper.findAttach", map);
	}
	@Override
	public int updateAttach(Map<String, Object> map) {
		return sqlTemplate.update("attachMapper.updateAttach", map);
	}
	@Override
	public int deleteAttach(Map<String, Object> map) {
		return sqlTemplate.delete("attachMapper.deleteAttach", map);
	}
	

}
