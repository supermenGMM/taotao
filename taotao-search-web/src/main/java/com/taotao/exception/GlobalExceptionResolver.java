package com.taotao.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.mail.util.EmailSend;
import com.taotao.mail.util.EmailSendInfo;
import com.taotao.util.exception.MyException;

public class GlobalExceptionResolver implements HandlerExceptionResolver{

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class); 
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		//写日志文件	
		logger.error("系统发生异常", ex);
//		发邮件
		
		EmailSendInfo mailInfo = EmailSend.getEmailAuthenticator("852458550@qq.com", "淘淘商城系统异常", StractTrace.getStraceTrace(ex));
		EmailSend.sendTextMail(mailInfo);
//		发短信
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		//		错误展示页面
		if(ex instanceof MyException ){
			modelAndView.addObject("message", ex.getMessage());			
		}else{
			modelAndView.addObject("message", "未知错误,正在努力修复中");
		}
		
		modelAndView.setViewName("/error/exception");
		
		return modelAndView;
	}

}
