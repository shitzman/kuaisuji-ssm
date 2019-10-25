package com.kuaisuji.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuaisuji.dao.TypeDao;
import com.kuaisuji.po.Type;

public class TypeTest {
	TypeDao typeDao;
	public TypeTest(){
		ApplicationContext springapp = new ClassPathXmlApplicationContext("springapp-context.xml");
		typeDao =springapp.getBean(TypeDao.class);
	}

	@Test
	public void springMybatisUser(){
		ApplicationContext springapp = new ClassPathXmlApplicationContext("springapp-context.xml");
		TypeDao typeDao =springapp.getBean(TypeDao.class);
		
		List<Type> typeList = typeDao.getAllType();
		for(Type t : typeList){
			System.out.println(t);
		}
		
	}
	

}
