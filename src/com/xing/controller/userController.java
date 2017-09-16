package com.xing.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 *@author xpengfei
 *@creat  2:56:32 PM   Sep 15, 2017
 */
@Controller
@RequestMapping(value="/user")//注解类,该类下的所有方法都对应改路径
@SessionAttributes("user")  //将Model中属性名为user的属性放入HttpSession对象中
public class userController {
	//定义静态User类型的list用于代替数据库保存用户注册的信息
	private static List<User>userList;
	//构造类,初始化List
	public userController(){
		userList=new ArrayList<User>();
	}
	private static final Log logger=LogFactory.getLog(userController.class);
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	//响应请求http://localhost:8080/SpringMVCTest/user/register    支持get方法
	public String registerForm(){
		logger.info("register  get 方法被调用-------------------");
		//跳转到注册页面
		return "register";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	//响应请求http://localhost:8080/SpringMVCTest/user/register 支持post方法
	public String register(
			//将请求中的username参数的值赋给username变量,其他两个同样处理
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("testName") String testName
			){
		logger.info("register post 方法被调用------");
		//创建User对象
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setTestName(testName);
		
		//模拟数据库存储user
		userList.add(user);
		//跳转到登录界面
		return "login";
	}
	
	//响应请求http://localhost:8080/SpringMVCTest/user/login
	@RequestMapping(value="/login")
	public String login(
			//将请求中的username参数的值赋给username变量,其他两个做同样处理
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model model
			){
		logger.info("登录名:"+username+"\t密码:"+password);
		//在集合中查找用户是否存在,
		for(User user:userList){
			//若用户名和密码不匹配,则不会跳转到欢迎页面
			if(user.getUsername().equals(username)
					&& user.getPassword().equals(password)){
				model.addAttribute("user", user);
				return "welcome";
			}
		}
		return "login";
	}
}
