package com.kuaisuji.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuaisuji.po.User;
import com.kuaisuji.service.UserService;

public class UserServiceTest {
	UserService userService;
	public UserServiceTest(){
		ApplicationContext springapp = new ClassPathXmlApplicationContext("springapp-context.xml");
//		userService = (UserService) springapp.getBean("userServiceImpl");
		userService = springapp.getBean(UserService.class);
	}
	
	@Test
	public void showUserByEmailAndPassword() {
		String user_email = "123@qq.com";
		String user_password = "123";
		System.out.println(userService.getUserByEmailAndPwd(user_email, user_password));
	}
	@Test
	public void addUserTest(){
		User user = new User();
		user.setUser_email("tx:test1");
		user.setUser_name("tx:test1");
		user.setUser_password("tx:test1");
		user.setUser_ip("tx:test1");
		int flag = userService.addUser(user);
		if(flag>0){
			System.out.println("添加用户成功");
		}else{
			System.out.println("添加用户失败");
		}
	}
	
	@Test
	public void addUserErrorTest(){
		User user = new User();
		user.setUser_email("tx-error:test1");
		user.setUser_name("tx-error:test1");
		user.setUser_password("tx-error:test1");
		user.setUser_ip("tx-error:test1");
		int flag = userService.addUserError(user);
		if(flag>0){
			System.out.println("添加用户成功");
		}else{
			System.out.println("添加用户失败");
		}
	}

}
