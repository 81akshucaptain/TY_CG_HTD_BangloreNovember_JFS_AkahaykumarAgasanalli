<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="library">
		<books> <book> <name>two states</name> <author>
		chetan bhagat </author></book> <book> <name> half girlfriend </name> <author>badhsha</author> </book> </books>
	</c:set>
	<x:parse xml="${library}" var="output" />
	<x:choose>
		<x:when select="$output//book/name='two states'">
			<h3>book is written by CHetan bhagat</h3>ṁ
		</x:when>
		<x:when select="$output//book/author='badhsha'">
			<h3>book name is half girlfriend</h3>
		</x:when>
		<x:otherwise>
	fuck it
	</x:otherwise>
	</x:choose>
</body>
</html>