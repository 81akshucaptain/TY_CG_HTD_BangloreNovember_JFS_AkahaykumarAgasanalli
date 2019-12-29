<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./home">home</a>
	<a href="./logout" style="float: right;">logout</a>
	<form action="./changepassword" method="post">
		<table>
			<tr>
				<td>Enter password</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="change password"></td>
			</tr>
		</table>
	</form>
</body>
</html>