package com.kuaisuji.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuaisuji.dao.TypeDao;
import com.kuaisuji.dao.UserDao;
import com.kuaisuji.po.User;



public class UserTest {
	UserDao userDao;
	public UserTest(){
		ApplicationContext springapp = new ClassPathXmlApplicationContext("springapp-context.xml");
		userDao = springapp.getBean(UserDao.class);
	}

	@Test
	public void addUserTest(){
		
		User user = new User();
		user.setUser_email("test1");
		user.setUser_name("test1");
		user.setUser_password("test1");
		user.setUser_ip("test1");
		int flag = userDao.addUser(user);
		if(flag>0){
			System.out.println("添加用户成功");
		}else{
			System.out.println("添加用户失败");
		}
	}
	
	@Test
	public void spirngMybatisUser(){
		User user = userDao.getUserById(1);
		System.out.println(user);
		
	}
	
	@Test
	public void getUserByEmailAndPwdTest(){
		String userEmail = "123456@163.com";
		String userPassword = "123456";
		
		User user = userDao.getUserByEmailAndPwd(userEmail, userPassword);
		System.out.println(user);
		
	}
	
	


}
