<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>


<body>
<form action="AcceptorReject?varname=ceo" method="post">
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
</tr>
<%
ResultSet rs = (ResultSet)session.getAttribute("rs");
while(rs.next())
{%>
<tr><%
	out.println("<td>"+rs.getDate(1)+"</td><td>"+rs.getDate(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getInt(7)+"</td><td>"+rs.getString(8)+"</td><td>");
	%>
	<td><input type="submit" name="name1" value="<%=rs.getInt(7)%>"></td>
<%}
%></tr>
</table>
</form>
</body>
</html>