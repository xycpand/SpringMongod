package com.mongodb.service;

import java.util.List;

import com.mongodb.domain.Users;

/**
 * 用户操作
 * 创建时间	2015年3月10日
 *
 */
public interface UserService {
	
	public void saveUser(Users user);
	public Users findUserByName(String name);
	public void removeUser(String name);
	public void updateUser(String name,String key,String value);
	public List<Users> listUser();

}
