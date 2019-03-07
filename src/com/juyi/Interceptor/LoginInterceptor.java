package com.juyi.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.juyi.model.admin;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String uri = request.getRequestURI();
		if(uri.indexOf("login.action")>=0) {
			return true;
		}
		HttpSession session = request.getSession();
		admin admin= (com.juyi.model.admin) session.getAttribute("admin");
		if(admin!=null) {
			return true;
		}
		String prompt="请先登录";
		request.setAttribute("prompt", prompt);
		request.getRequestDispatcher("../admin/login.action").forward(request, response);
		return false;
	}

}
