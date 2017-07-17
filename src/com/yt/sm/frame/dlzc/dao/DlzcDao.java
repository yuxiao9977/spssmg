package com.yt.sm.frame.dlzc.dao;

import java.util.List;
import java.util.Map;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public interface DlzcDao {

	List<User> getUserByname(Map<String, Object> map);

	int addPerson(Map<String, Object> map);

	List<Person> findPersonList(Map<String, Object> map);

	int addUser(Map<String, Object> map);

	int addGroup(Map<String, Object> map);

	List<Group> findGroupList(Map<String, Object> map);

	int deleteUser(Map<String, Object> map);

	User getOneUser2(Map<String, Object> map);

	int updateUser(Map<String, Object> map);

}
