<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fmt:bundle basename="/jsppractice/src/sppractice/tcs/SimpleForBundleEx.java" prefix="colour.">  
   <fmt:message key="Violet"/><br/>  
   <fmt:message key="Indigo"/><br/>  
  <fmt:message key="Blue"/><br/>  
  
</fmt:bundle>  
</body>
</html>