<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose PAGE</title>
</head>
<body>
	<c:set var="data" scope="page" value="${400*2}" />
	<p>
		income is :
		<c:out value="${data}"/>
		</p>
		<c:choose>
			<c:when test="${data>=1000}">
				<p>Excellent</p>
			</c:when>
			<c:when test="${data==400}">
				<p>good</p>
			</c:when>
			<c:otherwise>
				<p>worst</p>
			</c:otherwise>
		</c:choose>
</body>
</html>