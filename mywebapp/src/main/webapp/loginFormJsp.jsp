<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 	SCRIPT-LET TAG -->
<%@ page session="false" %>
	<% String msg=(String)request.getAttribute("msg");%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- EXPRESSION TAG THERE WILL NOT BE ANY SEMICOLONS -->
<%if(msg!=null && !msg.isEmpty()){ %>
<%=msg %>
<%} %>
	<fieldset>
		<legend>Login page</legend>
		<form action="./login2" method="post">

			<table>
				<tr>
					<td>id</td>
					<td>:</td>
					<td><input type="number" name="empId" required></td>
				</tr>
				<tr>
					<td>password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="Login"></td>
				</tr>
			</table>
			<h3>ITS JSP LOGIN PAGE</h3>
		</form>
	</fieldset>

</body>
</html>