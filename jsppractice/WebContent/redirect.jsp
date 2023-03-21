<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirecting</title>
</head>
<body>
 <c:set var="url" value="0" scope="request"/>  
  <c:if test="${url<1}">  
     <c:redirect url="http://instagram.com"/>  
  </c:if>  
  <c:if test="${url>1}">  
     <c:redirect url="http://facebook.com"/>  
  </c:if>  
</body>
</html>