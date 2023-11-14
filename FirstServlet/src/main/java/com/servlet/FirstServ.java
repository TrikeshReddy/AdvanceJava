package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class FirstServ extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("uname");
		String password=req.getParameter("pwd");
		//LoginCheck loginCheck=new LoginCheck();
		//loginCheck.checkCredentials(username, password);
//		PrintWriter pw=resp.getWriter();
//		pw.print("loginsucces");
		
		
		resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();//get the stream to write the data  
		  
		//writing html in the stream  
	pw.println("<html><body>");
	pw.println("<form action=\"secondEndPoint\" method=\"get\"><input type=\"text\" name=\"uname\" placeholder=\"user name\">\r\n"
			+ "    <input type=\"text\" name=\"pwd\" placeholder=\"password\"> <input type=\"submit\"> ");
		pw.println("<p>Welcome to servlet</p>");  
		pw.println("</body></html>");  
		  
		pw.close();//closing the stream
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get called");
	}
}
