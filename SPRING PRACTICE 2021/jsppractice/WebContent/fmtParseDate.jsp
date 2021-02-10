<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Parsed Date:</h3>
	<c:set var="date" value="12-08-2016" />

	<fmt:parseDate value="${date}" var="parsedDate" pattern="dd-MM-yyyy" />
	<p>
		<c:out value="${parsedDate}" />
	</p>
</body>
</html>