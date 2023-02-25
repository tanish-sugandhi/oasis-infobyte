<%@include file="db.jsp" %>
<%@page import="java.sql.ResultSet" %>

<%
String email=request.getParameter("email");
String qr="select * from student where email=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1, email);
ResultSet rs=ps.executeQuery();
if(rs.next())
{   
	response.sendRedirect("npassword.html");
}
else
{
	 RequestDispatcher rd=request.getRequestDispatcher("update.html");
	 rd.forward(request,response);
	 out.println("please enter correct email");
}
%>