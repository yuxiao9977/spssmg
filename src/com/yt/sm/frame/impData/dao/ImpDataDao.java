package com.yt.sm.frame.impData.dao;

import java.util.List;
import java.util.Map;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;

public interface ImpDataDao {

	int addPerson(Map<String, Object> map);

	List<Person> findPersonList(Map<String, Object> map);

	int addGroup(Map<String, Object> map);

	List<Group> findGroupList(Map<String, Object> map);

}
