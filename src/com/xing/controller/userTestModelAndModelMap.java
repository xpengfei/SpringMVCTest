package com.xing.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *@author xpengfei
 *@creat  3:25:30 PM   Sep 15, 2017
 */
@Controller
public class userTestModelAndModelMap {
	private static final Log logger=LogFactory.getLog(userTestModelAndModelMap.class);
	
	@ModelAttribute
	public void userModel(String username,String password,Model model){
		logger.info("***********userModel方法***********");
		//创建User对象存储jsp页面传入的参数
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		//将user对象添加到Model中
		model.addAttribute("user", user);
	}
	
	@RequestMapping(value="login1")
	public String login(Model model){
		logger.info("login1---------------------");
		//从Model中获取User对象
		User user=(User)model.asMap().get("user");
		user.setTestName("hhhhhh1111111111");
		System.out.println(user+"************************");
		return "result1";
	}
}
