package com.yt.sm.frame.impData.service;

import java.util.List;
import java.util.Map;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;

public interface ImpDataService {
	/**
	 * 增加个人
	 * @param info
	 * @return
	 */
	int addPerson(Person person);
	/**
	 * 查询所有个人会员
	 * @return
	 */
	List<Person> findPersonList(Map<String, Object> map);
	/**
	 * 增加团体会员
	 * @param group
	 * @return
	 */
	int addGroup(Group group);
	/**
	 * 查询所有团体会员
	 * @return
	 */
	List<Group> findGroupList(Map<String, Object> map);

}
