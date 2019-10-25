package com.kuaisuji.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaisuji.po.Account;

public interface AccountService {
	// 根据用户id获取用户的所有账目信息
	public List<Account> getAllAccountByUserId(Integer user_id);

	// 添加账目信息
	public int addAccount(Account account);

	// 添加账目信息(错误测试)
	public int addAccountError(Account account);

	// 根据用户id和账单类型id获取账目信息
	public List<Account> getAllAccountByUserIdAndTypeId(@Param("user_id") Integer user_id,
			@Param("account_type") Integer account_type);
	
	// 根据用户id和账单种类获取账目信息
	public List<Account> getAllAccountByUserIdAndItem(@Param("user_id") Integer user_id,
			@Param("account_item") Integer account_item);
}
