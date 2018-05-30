package com.cover.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri=request.getRequestURI();  
	    //判断当前请求地址是否是登录地�?  
	    if(!(uri.contains("Login")||uri.contains("login")||uri.contains("register"))){  
	        //非登录请�?
	        if(request.getSession().getAttribute("user")!=null){  
	            //说明已经登录过，放行 
	            return true;
	        }else{  
	        	if(uri.contains("css")||uri.contains("js")||uri.contains("images")){  
	        		//如果是静态资源请求，放行
	        		return true;
	        	}else{
	        		//没有登录,跳转到登录界�? 
	        		response.sendRedirect(request.getContextPath()+"/user/toLogin.action");  
	        	}
	        }  
	    }else{  
	        //登录请求，直接放�?  
	    	return true; 
	    }  
		return false;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {}
}
