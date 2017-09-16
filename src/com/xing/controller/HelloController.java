package com.xing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *@author xpengfei
 *@creat  6:15:58 PM   Sep 14, 2017
 */
/**
 * HelloController是一个实现Controller接口的控制器
 * 可以处理一个单一的请求动作
 * @author xpengfei
 */
public class HelloController implements Controller{
	//定义一个私有静态log对象用于打印日志
	private static final Log logger=LogFactory.getLog(HelloController.class);
	/**
	 * handleRequest是Controller接口必须实现的方法,
	 * 该方法的参数的参数是对应请求的HttpServletRequest和HttpServletResponse
	 * 且必须返回一个包含视图名或视图名和模型的ModelAndView对象.
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		logger.info("handleRequest 被调用!");
		//创建准备返回的ModelAndView对象,该对象通常包含了返回视图名、模型的名称以及模型对象
		ModelAndView modelAndView=new ModelAndView();
		//添加模型数据,可以使任意的POJO对象
		modelAndView.addObject("message", "Hello World !");
		//设置逻辑视图名,视图解析器会根据该名字解析到具体的视图页面
		modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
		//返回ModelAndView对象
		return modelAndView;
	}

}
