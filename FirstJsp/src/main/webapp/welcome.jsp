
<html>  
<body>  
<%   
  
String name=request.getParameter("uname");  
out.print("Welcome "+name);  
  
pageContext.setAttribute("person",name,pageContext.PAGE_SCOPE);  
  
<a href="second.jsp">second jsp page</a>  
  
%>  
</body>  
</html>  