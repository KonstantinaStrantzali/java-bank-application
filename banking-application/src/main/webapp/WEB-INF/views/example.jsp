<%@page import="com.ab.entities.CurrentAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CurrentAccount a = (CurrentAccount)session.getAttribute("currentAccountToView"); %>

<%=a%>
<p>Hey </p>
<h2> Balance <%=  a.getBalance()   %> </h2>
</body>
</html>