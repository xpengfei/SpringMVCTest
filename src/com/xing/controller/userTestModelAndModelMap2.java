package com.xing.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author xpengfei
 *@creat  3:38:43 PM   Sep 15, 2017
 */
@Controller
public class userTestModelAndModelMap2 {
	private static final Log logger=LogFactory.getLog(userTestModelAndModelMap2.class);
	
	@ModelAttribute  //@ModelAttribute注解修饰的方法会先于login调用,用于接收前台jsp页面传入的参数
	public void userModel2(String username,String password,ModelMap modelMap){
		logger.info("userModel2***********");
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setTestName("hhhhh2222222222");
		modelMap.addAttribute("user", user);
	}
	
	@RequestMapping(value="/login2")
	public String login2(ModelMap modelMap){
		logger.info("login2***************");
		User user=(User)modelMap.get("user");
		System.out.println(user+"---------------------");
		return "result2";
	}
}
