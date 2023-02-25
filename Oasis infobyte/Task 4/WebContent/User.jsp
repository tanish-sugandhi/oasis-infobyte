<%@include file="db.jsp" %>
<%@page import="java.sql.ResultSet" %>
<%
 String email=request.getParameter("email");
 String pwd=request.getParameter("pwd");
 String qr="select * from student where email=? and pwd=?";
 PreparedStatement ps=con.prepareStatement(qr);
 ps.setString(1,email);
 ps.setString(2,pwd);
 ResultSet rs=ps.executeQuery();
 if(rs.next())
 {
	 response.sendRedirect("uhome.html");
 }
 else
 {
	 RequestDispatcher rd=request.getRequestDispatcher("user.html");
	 rd.include(request,response);
	 out.println("Invalid email and pwd");
 }
%>