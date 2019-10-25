package com.kuaisuji.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuaisuji.po.Account;
import com.kuaisuji.po.Type;
import com.kuaisuji.po.User;
import com.kuaisuji.service.AccountService;
import com.kuaisuji.service.UserService;

@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	UserService userService;

	//根据所选类型返回该用户的账目信息
	@RequestMapping("/getaccounts")
	public String getAccounts(@RequestParam(name = "type", defaultValue = "2") String type, Model model,HttpSession session) {
		//判断是否登陆
		User user = (User) session.getAttribute("user");
		if(user == null){
			model.addAttribute("msg", "你还未登陆");
			return "login";
		}
		
		//根据所选类型返回该用户的账目信息
		List<Account> accountList = null;
		int accountType = Integer.parseInt(type);
		if(accountType==2){
			accountList = accountService.getAllAccountByUserId(user.getUser_id());
		}else{
			accountList = accountService.getAllAccountByUserIdAndTypeId(user.getUser_id(), accountType);
		}
		
		model.addAttribute("accountList",accountList);
		return "afterlogin/main";
	}
	
	//根据所选项目类型返回该用户的账目信息
	@RequestMapping("/getaccountsbyitem")
	public String getAccountsByItem(String cid,Model model,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user == null){
			model.addAttribute("msg", "你还未登陆");
			return "login";
		}
	
		int account_item = Integer.parseInt(cid);
		//根据所选项目类型返回该用户的账目信息
		List<Account> accountList = accountService.getAllAccountByUserIdAndItem(user.getUser_id(), account_item);
		model.addAttribute("accountList",accountList);
		return "afterlogin/main";
	}
	
	
	//访问添加页面并附带相关项目信息
	@RequestMapping({"add0","add.jsp"})
	public String toadd0(HttpSession session, Model model){
		Map<Integer,Type> typeMap = (Map<Integer, Type>) session.getAttribute("typeMap");
		Map<Integer,Type> typeMap0 = new HashMap();
		for(Integer key : typeMap.keySet()){
			
			if(typeMap.get(key).getAccount_type()==0){
				typeMap0.put(key, typeMap.get(key));
			}
		}
		model.addAttribute("typeMap0", typeMap0);
		return "afterlogin/add0";
	}
	@RequestMapping("add1")
	public String toadd1(HttpSession session, Model model){
		Map<Integer,Type> typeMap = (Map<Integer, Type>) session.getAttribute("typeMap");
		if(typeMap==null) {
			model.addAttribute("msg", "你还未登录");
			return "login";
		}
		Map<Integer,Type> typeMap1 = new HashMap();
		for(Integer key : typeMap.keySet()){
			if(typeMap.get(key).getAccount_type()==1){
				typeMap1.put(key, typeMap.get(key));
			}
		}
		model.addAttribute("typeMap1", typeMap1);
		return "afterlogin/add1";
	}
	
	//账目添加操作
	@RequestMapping("/addaccount")
	public String addAccount(Account account,HttpSession session,Model model) {
		//填上用户id
		User user = (User) session.getAttribute("user");
		if(user==null) {
			model.addAttribute("msg", "你还未登录");
			return "login";
		}
		account.setUser_id(user.getUser_id());
		//当用户未填写时间时，为其自动设置为现在的时间
		if(account.getAccount_date() == "") {	
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			account.setAccount_date(sdf.format(now));
		}
		//写入数据库
		int flag = accountService.addAccount(account);
		if(flag>0) {
			return "redirect:/getaccounts";
		}
		return "redirect:/add"+account.getAccount_type();
		
	}
	
	

}
