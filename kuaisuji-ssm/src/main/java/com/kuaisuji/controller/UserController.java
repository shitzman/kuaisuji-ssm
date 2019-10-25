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
	
	//注册
	@RequestMapping(value="/reg",method = RequestMethod.POST)
	public String addUser(User user,Model model,HttpSession session) {
		if(userService.checkUserByEmail(user.getUser_email())>0) {
			model.addAttribute("msg", "该邮箱已被注册");
			model.addAttribute("userEmail",user.getUser_email());
			return "reg";
		}
		if(!(userService.addUser(user)>0)) {
			model.addAttribute("msg", "注册失败！！");
			model.addAttribute("userEmail",user.getUser_email());
			return "reg";
		}
		//重新在数据库获取用户信息（得到用户在数据库中自增获得的id）
		user = userService.getUserByEmailAndPwd(user.getUser_email(), user.getUser_password());
		//将用户注册信息存入session
		session.setAttribute("user", user);
		//页面显示辅助信息
		Map<Integer,Type> typeMap = typeServiceImpl.getAllType();
		session.setAttribute("typeMap", typeMap);
		
		return "redirect:/getaccounts";
	}
	@RequestMapping(value="login" ,method=RequestMethod.POST)
	public String userLogin(String email,String password,Model model,HttpSession session){

		User user = userService.getUserByEmailAndPwd(email, password);
		if(user == null){
			model.addAttribute("msg", "查无此人");
			model.addAttribute("userEmail",email);
			return "login";
		}
		//获取页面显示辅助信息
		Map<Integer,Type> typeMap = typeServiceImpl.getAllType();
		List<Account> accountList = accountService.getAllAccountByUserId(user.getUser_id());
		session.setAttribute("user", user);
		session.setAttribute("typeMap", typeMap);
		model.addAttribute("accountList", accountList);
		
		return "afterlogin/main";
	}
	
	//退出
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
