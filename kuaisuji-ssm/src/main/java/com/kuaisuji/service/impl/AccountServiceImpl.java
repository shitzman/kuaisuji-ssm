package com.kuaisuji.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaisuji.dao.AccountDao;
import com.kuaisuji.po.Account;
import com.kuaisuji.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao accountDao;

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAllAccountByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		return accountDao.getAllAccountByUserId(user_id);
	}

	@Override
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.addAccount(account);
	}

	@Override
	public int addAccountError(Account account) {
		// TODO Auto-generated method stub
		int flag = accountDao.addAccount(account);
		int i = 1/0;
		return flag;
	}

	@Override
	public List<Account> getAllAccountByUserIdAndTypeId(Integer user_id, Integer account_type) {
		// TODO Auto-generated method stub
		return accountDao.getAllAccountByUserIdAndTypeId(user_id, account_type);
	}

	@Override
	public List<Account> getAllAccountByUserIdAndItem(Integer user_id, Integer account_item) {
		// TODO Auto-generated method stub
		return accountDao.getAllAccountByUserIdAndItem(user_id, account_item);
	}

}
