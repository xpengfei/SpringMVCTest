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
 * HelloController��һ��ʵ��Controller�ӿڵĿ�����
 * ���Դ���һ����һ��������
 * @author xpengfei
 */
public class HelloController implements Controller{
	//����һ��˽�о�̬log�������ڴ�ӡ��־
	private static final Log logger=LogFactory.getLog(HelloController.class);
	/**
	 * handleRequest��Controller�ӿڱ���ʵ�ֵķ���,
	 * �÷����Ĳ����Ĳ����Ƕ�Ӧ�����HttpServletRequest��HttpServletResponse
	 * �ұ��뷵��һ��������ͼ������ͼ����ģ�͵�ModelAndView����.
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		logger.info("handleRequest ������!");
		//����׼�����ص�ModelAndView����,�ö���ͨ�������˷�����ͼ����ģ�͵������Լ�ģ�Ͷ���
		ModelAndView modelAndView=new ModelAndView();
		//���ģ������,����ʹ�����POJO����
		modelAndView.addObject("message", "Hello World !");
		//�����߼���ͼ��,��ͼ����������ݸ����ֽ������������ͼҳ��
		modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
		//����ModelAndView����
		return modelAndView;
	}

}
