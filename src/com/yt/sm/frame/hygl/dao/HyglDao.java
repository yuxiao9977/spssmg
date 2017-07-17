package com.yt.sm.frame.hygl.dao;

import java.util.List;
import java.util.Map;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Menu;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public interface HyglDao {

	int addPerson(Map<String, Object> map);

	int updatePerson(Map<String, Object> map);

	List<Menu> findAdminMenu(Map<String, Object> map);

	User getOneUser(Map<String, Object> map);

	int savePwd(Map<String, Object> map);

	Person getPersonInfo(Map<String, Object> map);

	Group getGroupInfo(Map<String, Object> map);

	int updateGroup(Map<String, Object> map);

	int getPersonTotal(Map<String, Object> map);

	List<Person> findPersonList(Map<String, Object> map);

	int delPerson(Map<String, Object> map);

	List<Group> findGroupList(Map<String, Object> map);

	int getGroupTotal(Map<String, Object> map);

	int delGroup(Map<String, Object> map);

	List<Person> findPersonList2(Map<String, Object> map1);

	List<Group> findGroupList2(Map<String, Object> map1);

	int getGroupMax(Map<String, Object> map);

	int getPersonMax(Map<String, Object> map);


}
