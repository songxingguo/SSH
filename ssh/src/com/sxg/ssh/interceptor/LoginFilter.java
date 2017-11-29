package com.sxg.ssh.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxg.ssh.domain.Student;

public class LoginFilter extends HttpServlet implements Filter {  
	  
    private static final long serialVersionUID = 1L;  
    public void init(FilterConfig arg0) throws ServletException {  
        //do something  
    }  
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,      
            FilterChain filterChain) throws IOException, ServletException{   
        HttpServletRequest request = (HttpServletRequest) sRequest;      
        HttpServletResponse response = (HttpServletResponse) sResponse;      
        HttpSession session = request.getSession();      
        String contextPath=request.getContextPath();  
  
        Student user=(Student)session.getAttribute("user");  
        if(user==null){//ת�����Ա��½ҳ��  
             response.sendRedirect(contextPath+"/login.jsp");  
             return;  
        } 
        
        filterChain.doFilter(sRequest, sResponse);    
    }  
  
}  
