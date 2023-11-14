package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class MangaeSession
 */
@WebServlet("/endPoint")
public class MangaeSession extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uName=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		resp.setContentType("text/html");  
		PrintWriter pw=resp.getWriter();//get the stream to write the data  
		  
		//writing html in the stream  
		pw.print("<form action='secondServlet'>");  
        pw.print("<input type='hidden' name='uname' value='"+uName+"'>");  
        pw.print("<input type='submit' value='go'>");  
        pw.print("</form>");    
		  
		pw.close();
		
		
	}

}
