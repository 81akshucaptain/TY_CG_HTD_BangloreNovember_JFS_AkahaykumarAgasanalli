<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ParseNumber</title>
</head>
<body>
	<h1>Parse Number Result</h1>
	<c:set var="amount" value="365.25" />
	<!-- to Parse the String representation of the amoint,currency,or percentage -->
<fmt:parseNumber var="j"  type="number" value="${amount}" />
 --%><%-- 	<fmt:parseNumber var="j" integerOnly="true" type="number" value="${amount}" />
 --%>	<p>
		amount is:
		<c:out value="${amount}"></c:out>
	</p>
</body>
</html>