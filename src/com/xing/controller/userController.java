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
@RequestMapping(value="/user")//ע����,�����µ����з�������Ӧ��·��
@SessionAttributes("user")  //��Model��������Ϊuser�����Է���HttpSession������
public class userController {
	//���徲̬User���͵�list���ڴ������ݿⱣ���û�ע�����Ϣ
	private static List<User>userList;
	//������,��ʼ��List
	public userController(){
		userList=new ArrayList<User>();
	}
	private static final Log logger=LogFactory.getLog(userController.class);
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	//��Ӧ����http://localhost:8080/SpringMVCTest/user/register    ֧��get����
	public String registerForm(){
		logger.info("register  get ����������-------------------");
		//��ת��ע��ҳ��
		return "register";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	//��Ӧ����http://localhost:8080/SpringMVCTest/user/register ֧��post����
	public String register(
			//�������е�username������ֵ����username����,��������ͬ������
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("testName") String testName
			){
		logger.info("register post ����������------");
		//����User����
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setTestName(testName);
		
		//ģ�����ݿ�洢user
		userList.add(user);
		//��ת����¼����
		return "login";
	}
	
	//��Ӧ����http://localhost:8080/SpringMVCTest/user/login
	@RequestMapping(value="/login")
	public String login(
			//�������е�username������ֵ����username����,����������ͬ������
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model model
			){
		logger.info("��¼��:"+username+"\t����:"+password);
		//�ڼ����в����û��Ƿ����,
		for(User user:userList){
			//���û��������벻ƥ��,�򲻻���ת����ӭҳ��
			if(user.getUsername().equals(username)
					&& user.getPassword().equals(password)){
				model.addAttribute("user", user);
				return "welcome";
			}
		}
		return "login";
	}
}
