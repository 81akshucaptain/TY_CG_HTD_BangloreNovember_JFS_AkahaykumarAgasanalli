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
<c:set var="s1" value="jack sparoow calss of product"/>
<c:set var="s2" value="${fn:split(s1, ' ')}"/>
<c:set var="s3" value="${fn:join(s2, '-')}"/>
<p>s3 is : ${s3}</p>
</body>
</html>