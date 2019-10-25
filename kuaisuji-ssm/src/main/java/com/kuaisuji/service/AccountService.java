package com.kuaisuji.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuaisuji.po.Account;

public interface AccountService {
	// �����û�id��ȡ�û���������Ŀ��Ϣ
	public List<Account> getAllAccountByUserId(Integer user_id);

	// �����Ŀ��Ϣ
	public int addAccount(Account account);

	// �����Ŀ��Ϣ(�������)
	public int addAccountError(Account account);

	// �����û�id���˵�����id��ȡ��Ŀ��Ϣ
	public List<Account> getAllAccountByUserIdAndTypeId(@Param("user_id") Integer user_id,
			@Param("account_type") Integer account_type);
	
	// �����û�id���˵������ȡ��Ŀ��Ϣ
	public List<Account> getAllAccountByUserIdAndItem(@Param("user_id") Integer user_id,
			@Param("account_item") Integer account_item);
}
