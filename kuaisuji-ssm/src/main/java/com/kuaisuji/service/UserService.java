package com.kuaisuji.service;

import org.apache.ibatis.annotations.Param;

import com.kuaisuji.po.User;

public interface UserService {

	// �����û�id����û���Ϣ
	public User getUserById(Integer user_id);

	// ����û�
	public int addUser(User user);
	// ����û�
	public int addUserError(User user);

	// �����û�����������ѯ�û�
	public User getUserByEmailAndPwd(@Param("user_email") String user_email,
			@Param("user_password") String user_password);
	
	//�����û������ѯ�Ƿ��ѱ�ע��
	public int checkUserByEmail(String eamil);
}
