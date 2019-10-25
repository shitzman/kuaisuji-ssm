package com.kuaisuji.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuaisuji.po.Account;
import com.kuaisuji.service.AccountService;

public class AccountTest {
	
	AccountService accountServiceImpl;
	
	public AccountTest(){
		ApplicationContext springapp = new ClassPathXmlApplicationContext("springapp-context.xml");
		accountServiceImpl =(AccountService) springapp.getBean("accountServiceImpl");
	}
	
	@Test
	public void getAllAccountByUserId(){
		List<Account> accountList = accountServiceImpl.getAllAccountByUserId(1);
		System.out.println(accountList);
		
	}
	@Test
	public void addAccountTest(){
		Account account = new Account();
		account.setUser_id(1);
		account.setAccount_date("2019/5/9");
		account.setAccount_amount("99");
		account.setAccount_item(2);
		account.setAccount_type(0);
		account.setAccount_remark("testmybatis");
		int flag = accountServiceImpl.addAccount(account);
		if(flag>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		
	}
	
	@Test
	public void addAccountTestError(){
		Account account = new Account();
		account.setUser_id(1);
		account.setAccount_date("2019/5/9");
		account.setAccount_amount("444");
		account.setAccount_item(2);
		account.setAccount_type(0);
		account.setAccount_remark("testmybatis:error");
		int flag = accountServiceImpl.addAccountError(account);
		if(flag>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		
	}
	

}
