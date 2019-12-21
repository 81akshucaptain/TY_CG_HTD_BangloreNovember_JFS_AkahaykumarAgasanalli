<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form here</title>
</head>
<body>
	<h2>${name}</h2>
	<h2>${email}</h2>
	<h2>${password}</h2>
	<h2>${gender}</h2>
	<h1>Submit The form</h1>

	<form action="./form" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<!-- 			<tr> -->
			<!-- 				<td>usn:</td> -->
			<!-- 				<td><input type="text" name="usn"></td> -->
			<!-- 			</tr> -->
			<tr>
			<tr>
				<td>gender:</td>
				<td>M<input type="radio" value="M" name="gender" >F
				<input type="radio" value="F" name="gender" ></td>

			</tr>
			<tr>
				<td>email:</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>