<%@include file="db.jsp" %>
<%
  String name=request.getParameter("name");
  String email=request.getParameter("email");
  String p=request.getParameter("age");
  int age=Integer.parseInt(p);
  String dob=request.getParameter("dob");
  String gender=request.getParameter("gender");
  String course=request.getParameter("course");
  String enrono=request.getParameter("enrono");
  String pwd=request.getParameter("pwd");
  String qr="insert into student value(?,?,?,?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1,name);
	ps.setString(2,email);
	ps.setInt(3,age);
	ps.setString(4,dob);
	ps.setString(5,gender);
	ps.setString(6,course);
	ps.setString(7,enrono);
	ps.setString(8,pwd);
	int i=ps.executeUpdate();
	out.println(i+"successfully Registered");
	con.close();
%>