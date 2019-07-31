<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ValidateServlet?varname=apply" method="post">
		<table>
			<tr>
				<td>Enter start date:<input type="date" name="start"></td>
			</tr>
			<tr>
				<td>Enter End date:<input type="date" name="end"></td>
			</tr>
			<tr>
				<td>Enter the Reason:<input type="text" name="reason"></td>
			</tr>
			<tr>
				<td>Enter the current month:<input type="number" name="month"></td>
			</tr>

			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>