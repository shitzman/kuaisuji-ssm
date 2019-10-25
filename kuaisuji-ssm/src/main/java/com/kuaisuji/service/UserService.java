package com.kuaisuji.service;

import org.apache.ibatis.annotations.Param;

import com.kuaisuji.po.User;

public interface UserService {

	// 根据用户id获得用户信息
	public User getUserById(Integer user_id);

	// 添加用户
	public int addUser(User user);
	// 添加用户
	public int addUserError(User user);

	// 根据用户邮箱和密码查询用户
	public User getUserByEmailAndPwd(@Param("user_email") String user_email,
			@Param("user_password") String user_password);
	
	//根据用户邮箱查询是否已被注册
	public int checkUserByEmail(String eamil);
}
