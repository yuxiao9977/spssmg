package com.yt.sm.frame.dlzc.service;

import java.util.List;

import com.yt.sm.frame.hygl.vo.Group;
import com.yt.sm.frame.hygl.vo.Person;
import com.yt.sm.frame.hygl.vo.User;

public interface DlzcService {
	/**
	 * 根据登录名获取用户
	 * @param user
	 * @return
	 */
	List<User> getUserByname(User user);
	/**
	 * 增加个人会员
	 * @param person
	 * @return
	 */
	int addPerson(Person person);
	/**
	 * 查找所有个人会员
	 * @return
	 */
	List<Person> findPersonList();
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	int deleteUser(User user);
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 增加团体会员
	 * @param group
	 * @return
	 */
	int addGroup(Group group);
	/**
	 *  查找所有团体会员
	 * @return
	 */
	List<Group> findGroupList();
	/**
	 * 获得一个用户
	 * @param user
	 * @return
	 */
	User getOneUser2(User user);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);

}
