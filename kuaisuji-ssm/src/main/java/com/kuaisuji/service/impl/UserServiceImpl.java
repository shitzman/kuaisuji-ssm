package com.kuaisuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaisuji.dao.UserDao;
import com.kuaisuji.po.User;
import com.kuaisuji.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	@Transactional(readOnly=true)
	public User getUserById(Integer user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(user_id);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public User getUserByEmailAndPwd(String user_email, String user_password) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmailAndPwd(user_email, user_password);
	}

	@Override
	public int addUserError(User user) {
		// TODO Auto-generated method stub
		int flag = userDao.addUser(user);
		int a = 1/0;
		return flag;
	}

	@Override
	public int checkUserByEmail(String eamil) {
		// TODO Auto-generated method stub
		return userDao.checkUserByEmail(eamil);
	}

}
