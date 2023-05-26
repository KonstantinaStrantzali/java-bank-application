<%@page import="com.ab.entities.SavingAccount"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% SavingAccount a = (SavingAccount)session.getAttribute("savingAccount"); %>


    Hello <%= " " + a.getAccountName() + "!" %>
<h1> Your Account Details  </h1>
<h2> Balance <%=  a.getBalance()   %> </h2>




</body>
</html>