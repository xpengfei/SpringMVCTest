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
 *@PathVariable��@RequestHeader��@CookieValueע���ʾ��
 */
@Controller
@RequestMapping(value="/user")
public class PRCController {
	private static final Log logger=LogFactory.getLog(PRCController.class);
//	��ת��jspҳ��
	@RequestMapping(value="/PRCController")
	public String PRCController(){
		return "PRCController";
	}
	
	/*
	 * ����@PathVariableע��
	 * �÷���ӳ�������Ϊ:
	 */
	@RequestMapping(value="/pathVariableTest/{userId}")
	public void pathVariableTest(
			@PathVariable Integer userId
			){
		logger.info("ͨ��@PathVariable��ȡ������:"+userId);
	}
	/*
	 * ���Է���@RequestHeaderע��
	 * �÷���ӳ�������Ϊ:
	 */
	@RequestMapping(value="/requestHeaderTest")
	public void requestHeaderTest(
				@RequestHeader("User-Agent") String userAgent,
				@RequestHeader(value="Accept") String[]accepts
			){
		logger.info("ͨ��@RequestHeaderע���õ�����:"+userAgent);
		for(String accept: accepts){
			logger.info(accept+"-------------");
		}
	}
	/*
	 * ����@CookieValueע��
	 */
	@RequestMapping(value="/CookieValueTest")
	public void cookieValueTest(
				@CookieValue(value="JSEEIONID",defaultValue="")String sessionId
			){
		logger.info("ͨ��@CookieValueTest��õ�����:"+sessionId);
	}
}
