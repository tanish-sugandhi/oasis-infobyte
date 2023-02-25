<%@include file="db.jsp" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<table align="center" border="1px">

<%
   String qr="select * from student";
   Statement st=con.createStatement();
   ResultSet rs=st.executeQuery(qr);
   if(rs.next())
	   
   {
	   out.println("<th>name</th>");
	   out.println("<th>email</th>");
	   out.println("<th>age</th>");
	   out.println("<th>dob</th>");
	   out.println("<th>gender</th>");
	   out.println("<th>course</th>");
	   out.println("<th>enrono</th>");
	   out.println("<th>pwd</th>");
	   do
	   {
		   String name=rs.getString("name");
		   String email=rs.getString("email");
		   int age=rs.getInt("age");
		   String dob=rs.getString("dob");
		   String gender=rs.getString("gender");
		   String course=rs.getString("course");
		   String enrono=rs.getString("enrono");
		   String pwd=rs.getString("pwd");
		   %>
		    <tr>
		    <td><input type="text" name="name" value="<%=name %>"></td>
		    <td><input type="email" name="email" value="<%=email %>"></td>
		    <td><input type="number" name="age" value="<%=age %>"></td>
		    <td><input type="date" name="dob" value="<%=dob %>"></td>
		    <td><input type="text" name="gender" value="<%=gender %>"></td>
		     <td><input type="text" name="course" value="<%=course %>"></td>
		     <td><%=enrono %><input type="hidden" name="enrono" value="<%=enrono %>"></td>
		     <td><input type="text" name="pwd" value="<%=pwd %>"></td> 
		     <td><a href="Del.jsp?enrono=<%=enrono %>">Delete</a></td>
		    </tr>
		   <% 
	   }while(rs.next());
   }
   else
   {
	   out.println("no records found");
   }

%>
</table>