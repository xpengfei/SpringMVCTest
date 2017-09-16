package com.xing.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author xpengfei
 *@creat  6:01:57 PM   Sep 15, 2017
 *@PathVariable、@RequestHeader、@CookieValue注解的示例
 */
@Controller
@RequestMapping(value="/user")
public class PRCController {
	private static final Log logger=LogFactory.getLog(PRCController.class);
//	跳转到jsp页面
	@RequestMapping(value="/PRCController")
	public String PRCController(){
		return "PRCController";
	}
	
	/*
	 * 测试@PathVariable注解
	 * 该方法映射的请求为:
	 */
	@RequestMapping(value="/pathVariableTest/{userId}")
	public void pathVariableTest(
			@PathVariable Integer userId
			){
		logger.info("通过@PathVariable获取的数据:"+userId);
	}
	/*
	 * 测试方法@RequestHeader注解
	 * 该方法映射的请求为:
	 */
	@RequestMapping(value="/requestHeaderTest")
	public void requestHeaderTest(
				@RequestHeader("User-Agent") String userAgent,
				@RequestHeader(value="Accept") String[]accepts
			){
		logger.info("通过@RequestHeader注解获得的数据:"+userAgent);
		for(String accept: accepts){
			logger.info(accept+"-------------");
		}
	}
	/*
	 * 测试@CookieValue注解
	 */
	@RequestMapping(value="/CookieValueTest")
	public void cookieValueTest(
				@CookieValue(value="JSEEIONID",defaultValue="")String sessionId
			){
		logger.info("通过@CookieValueTest获得的数据:"+sessionId);
	}
}
