<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="completeUrl" value="/index.jsp" >
		<c:param name="trackingID" value="858" />
		<c:param name="user" value="moonu" />
	</c:url>
	<p>URL is : ${completeUrl}</p>
</body>
</html>