<%@include file="db.jsp" %> 
 <%
  String enrono=request.getParameter("enrono");
  String qr="delete from student where enrono=?";
  PreparedStatement ps=con.prepareStatement(qr);
  ps.setString(1,enrono);
  int i=ps.executeUpdate();
  RequestDispatcher rd=request.getRequestDispatcher("Show.jsp");
  rd.include(request, response);
  out.println(i+"successfully delete");
  con.close();
 %>