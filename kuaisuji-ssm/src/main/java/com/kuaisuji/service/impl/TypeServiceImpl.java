package com.kuaisuji.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaisuji.dao.TypeDao;
import com.kuaisuji.po.Type;
import com.kuaisuji.service.TypeService;


@Service
public class TypeServiceImpl implements TypeService{
	
	@Autowired
	TypeDao typeDao;


	public Map<Integer, Type> getAllType() {
		// TODO Auto-generated method stub
		List<Type> typeList = typeDao.getAllType();
		Map<Integer,Type> typeMap = new HashMap();
		for(Type type : typeList){
			typeMap.put(type.getAccount_item(), type);
		}
		return typeMap;
	}

}
