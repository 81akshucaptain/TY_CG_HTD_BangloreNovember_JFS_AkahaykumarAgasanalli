<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>xml OUT</title>
</head>
<body>
	<c:set var="vegetable">
		<vegetables> <vegetable> <name>onion</name> <price>40/kg</price>
		</vegetable> <vegetable> <name>tomato</name> <price>55/kg</price> </vegetable> </vegetables>
	</c:set>
	<x:parse var="output" xml="${vegetable}" />
	<p>Name of the Vegetable</p>
	<x:out select="$output/vegetables/vegetable[1]/name" />
	<p>price of the Vegetable</p>
	<x:out select="$output/vegetables/vegetable[1]/price" />
</body>
</html>