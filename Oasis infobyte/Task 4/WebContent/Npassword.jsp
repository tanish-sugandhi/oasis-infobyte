<%@include file="db.jsp" %>

<%
String pwd=request.getParameter("pwd");
String email=request.getParameter("email");
String qr="update student set pwd=? where email=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(2,email);
ps.setString(1, pwd);
int i=ps.executeUpdate();
	 out.println(i+"successfully password change");
	 con.close();
%>