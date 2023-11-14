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
		PrintWriter pw=resp.getWriter();//get the stream to write the data  
		  
		//writing html in the stream  
		pw.println("<html><body>");
		pw.println("hi "+uName);
		
		pw.println("<a href='secondServlet?un="+uName+"&&pwd=hardcodedvalue'>visit</a>");  
		pw.println("</body></html>");  
		  
		pw.close();
		
		
	}

}
