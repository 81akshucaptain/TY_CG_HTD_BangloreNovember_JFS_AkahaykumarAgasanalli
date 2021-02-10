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
 <c:set var="s1" value="Welcome to JSP        programming         "/>
<p>the length of S1 is: ${fn:length(s1)}</p>

<c:set var="s2" value="${fn:trim(s1)}"/>
<p>s2 length is: ${fn:length(s2)}</p>
<p>S2 Content: ${s2}</p> 
<%-- <c:set var="str1" value="Welcome to JSP        programming         "/> 
<p>str1: ${str1}</p> 
<p>String-1 Length is : ${fn:length(str1)}</p>  
  
<c:set var="str2" value="${fn:trim(str1)}" />  
<p>String-2 Length is : ${fn:length(str2)}</p>  
<p>Final value of string is : ${str2}</p>   --%>
  
</body>
</html>