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
 * newHelloController��һ������ע��Ŀ�����,
 * ����ͬʱ������������,��������ʵ���κνӿ�
 */
@Controller
public class newHelloController {
	private static final Log logger=LogFactory.getLog(newHelloController.class);
	/*
	 * @RequestMappingע������ӳ�������URL������ķ���,
	 * ����һ��ModelAndView����
	 */
	@RequestMapping(value="/hello")
	public String hello(Model model){
		logger.info("hello ����������!");
		
//		//����׼�����ص�ModelAndView����
//		ModelAndView modelAndView=new ModelAndView();
//		//���ģ������
//		modelAndView.addObject("message", "Hello!");
//		//�����߼���ͼ��,��ͼ����������ݸ����ֽ������������ͼҳ��
//		modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
		model.addAttribute("message","Hello----World!");
		return "welcome";
	}
}
