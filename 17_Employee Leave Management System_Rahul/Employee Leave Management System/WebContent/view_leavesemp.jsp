<%@ page import="java.sql.*,Servlet_Package.*"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br>
<form method="post" action="AcceptorReject?varname=manager" >
	<table border="1">
<tr>
<th>Start Date</th>
<th>End Date</th>
<th>Reason</th>
<th>Month</th>
<th>Username</th>
<th>Days Left</th>
<th>Leave ID</th>
<th>Status</th>
<th>Employee Type</th>
<th>View</th>

</tr>
<tr>
<%
ResultSet rs = (ResultSet)request.getAttribute("rs");
while(rs.next()){
	
	out.print("<td>"+rs.getDate("start")+"</td>");
	out.print("<td>"+rs.getDate("end")+"</td>");
	out.print("<td>"+rs.getString("reason")+"</td>");
	out.print("<td>"+rs.getInt("month")+"</td>");
	out.print("<td>"+rs.getString("username")+"</td>");
	out.print("<td>"+rs.getInt("daysleft")+"</td>");
	out.print("<td>"+rs.getInt("leaveid")+"</td>");
	out.print("<td>"+rs.getString("status")+"</td>");
	out.print("<td>"+rs.getString("employeetype")+"</td>");
	%>
	<td><input type="submit" name="name1" value="<%=rs.getInt(7)%>"></td>
	</tr>
<%} %>


</table>
</form>   
</body>
</html>