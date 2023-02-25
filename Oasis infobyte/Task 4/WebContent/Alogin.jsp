<%@page import ="javax.servlet.RequestDispatcher"%>

<%
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
if(id.equals("admin")&&pwd.equals("12345"))
{
	response.sendRedirect("adminhome.html");
	
}
else
{
	out.println("<script>window.alert('Invalid id and password');</script>");
	
	
}
%>