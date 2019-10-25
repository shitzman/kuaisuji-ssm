package com.kuaisuji.dao;

import org.apache.ibatis.annotations.Param;

import com.kuaisuji.po.User;

public interface UserDao {

	//�����û�id����û���Ϣ
	public User getUserById(Integer user_id);
	//����û�
	public int addUser(User user);
	//�����û�����������ѯ�û�
	public User getUserByEmailAndPwd(@Param("user_email")String user_email,@Param("user_password")String user_password);
	//�����û������ѯ�Ƿ��ѱ�ע��
	public int checkUserByEmail(String eamil);
}
