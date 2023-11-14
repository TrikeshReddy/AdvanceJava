package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet{
 
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("hello");
			ServletConfig config=getServletConfig();  
			Enumeration<String> e=config.getInitParameterNames();  
			String str="";  
		    while(e.hasMoreElements()){  
		    str=e.nextElement();  
		    System.out.print("<br>Name: "+str);  
		    System.out.print(" value: "+config.getInitParameter(str));  
		    }  
			
		}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println(req);
		 ServletConfig config=getServletConfig();  
			Enumeration<String> e=config.getInitParameterNames();  
			String str="";  
		    while(e.hasMoreElements()){  
		    str=e.nextElement();  
		    System.out.print("<br>Name: "+str);  
		    System.out.print(" value: "+config.getInitParameter(str));  
		    }  
		}
}
