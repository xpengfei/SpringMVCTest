package com.xing.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *@author xpengfei
 *@creat  4:14:52 PM   Sep 15, 2017
 */
@Controller
public class userTestModelAndModelMap3 {
	private static final Log logger=LogFactory.getLog(userTestModelAndModelMap3.class);
	
	@ModelAttribute
	public void userModel3(String username,String password,ModelAndView modelAndView){
		logger.info("userModel3*************");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		//将user对象添加到ModelAndView的Model中
		modelAndView.addObject("user", user);
	}
	
	@RequestMapping(value="login3")
	public ModelAndView login3(ModelAndView modelAndView){
		logger.info("login3-----------");
		User user =(User)modelAndView.getModel().get("user");
		System.out.println(user);
		
		user.setTestName("333333hhhhhhhhhhhhhh");
		//设置返回的视图名称
		modelAndView.setViewName("result3");
		return modelAndView;
	}
}
