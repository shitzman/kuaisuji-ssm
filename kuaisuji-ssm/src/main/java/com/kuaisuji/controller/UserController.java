package com.kuaisuji.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuaisuji.po.Account;
import com.kuaisuji.po.Type;
import com.kuaisuji.po.User;
import com.kuaisuji.service.AccountService;
import com.kuaisuji.service.UserService;
import com.kuaisuji.service.impl.TypeServiceImpl;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	TypeServiceImpl typeServiceImpl;
	@Autowired
	AccountService accountService;
	
	//ע��
	@RequestMapping(value="/reg",method = RequestMethod.POST)
	public String addUser(User user,Model model,HttpSession session) {
		if(userService.checkUserByEmail(user.getUser_email())>0) {
			model.addAttribute("msg", "�������ѱ�ע��");
			model.addAttribute("userEmail",user.getUser_email());
			return "reg";
		}
		if(!(userService.addUser(user)>0)) {
			model.addAttribute("msg", "ע��ʧ�ܣ���");
			model.addAttribute("userEmail",user.getUser_email());
			return "reg";
		}
		//���������ݿ��ȡ�û���Ϣ���õ��û������ݿ���������õ�id��
		user = userService.getUserByEmailAndPwd(user.getUser_email(), user.getUser_password());
		//���û�ע����Ϣ����session
		session.setAttribute("user", user);
		//ҳ����ʾ������Ϣ
		Map<Integer,Type> typeMap = typeServiceImpl.getAllType();
		session.setAttribute("typeMap", typeMap);
		
		return "redirect:/getaccounts";
	}
	@RequestMapping(value="login" ,method=RequestMethod.POST)
	public String userLogin(String email,String password,Model model,HttpSession session){

		User user = userService.getUserByEmailAndPwd(email, password);
		if(user == null){
			model.addAttribute("msg", "���޴���");
			model.addAttribute("userEmail",email);
			return "login";
		}
		//��ȡҳ����ʾ������Ϣ
		Map<Integer,Type> typeMap = typeServiceImpl.getAllType();
		List<Account> accountList = accountService.getAllAccountByUserId(user.getUser_id());
		session.setAttribute("user", user);
		session.setAttribute("typeMap", typeMap);
		model.addAttribute("accountList", accountList);
		
		return "afterlogin/main";
	}
	
	//�˳�
	@RequestMapping("logout")
	public String userLogout(HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("typeMap");
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toUserLogin(String email,String password,Model model){
		return "login";
	}
	
	@RequestMapping(value="reg",method=RequestMethod.GET)
	public String toReg(){
		return "reg";
	}
	
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
}
