package com.xing.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author xpengfei
 *@creat  6:59:10 PM   Sep 14, 2017
 */
/**
 * newHelloController是一个基于注解的控制器,
 * 可以同时处理多个请求动作,并且无须实现任何接口
 */
@Controller
public class newHelloController {
	private static final Log logger=LogFactory.getLog(newHelloController.class);
	/*
	 * @RequestMapping注解用来映射请求的URL和请求的方法,
	 * 返回一个ModelAndView对象
	 */
	@RequestMapping(value="/hello")
	public String hello(Model model){
		logger.info("hello 方法被调用!");
		
//		//创建准备返回的ModelAndView对象
//		ModelAndView modelAndView=new ModelAndView();
//		//添加模型数据
//		modelAndView.addObject("message", "Hello!");
//		//设置逻辑视图名,视图解析器会根据改名字解析到具体的视图页面
//		modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
		model.addAttribute("message","Hello----World!");
		return "welcome";
	}
}
