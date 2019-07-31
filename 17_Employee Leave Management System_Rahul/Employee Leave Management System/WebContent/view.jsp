<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean_Package.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AcceptorRejectServlet" method="POST">
<table>

<tr>
<%
EmployeeBean bean =(EmployeeBean) request.getAttribute("bean");
out.println("test"+bean);
session.setAttribute("bean1", bean);

//request.setAttribute("leaveid", bean.getLeaveid());

	out.println("<td>"+bean.getStart()+"</td><td>"+bean.getEnd()+"</td><td>"+bean.getReason()+"</td><td>"+bean.getMonth()+"</td><td>"+bean.getUsername()+"</td><td>"+bean.getDays_left()+"</td><td>"+bean.getLeaveid()+"</td><td>"+bean.getStatus()+"</td><td>");
	out.println("</tr><tr>");
	

%>
</tr>
<tr><td><input type=hidden value="accept" name="option"><input type="submit" name="Accept" value="Accept"></td></tr>


<tr><td><a href="AcceptorRejectServlet?option=reject">Reject</a></td></tr>

</table>
</form>
</body>
</html>