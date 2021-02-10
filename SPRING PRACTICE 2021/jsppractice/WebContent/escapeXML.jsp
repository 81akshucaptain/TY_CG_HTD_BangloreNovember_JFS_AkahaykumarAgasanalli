<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="S1" value="jack sparoow"/>
<c:set var="S2" value="jack<abc> boss umder xml</abc>"/>
<h1>with.... escape XML</h1>
<p>S1:${fn:escapeXml(S1)}</p> 
<p>S1:${fn:escapeXml(S2)}</p> 
<h1>without,,,, escape XML</h1>
<p>S1:${S1}</p> 
<p>S1:${S2}</p> 
</body>
</html>