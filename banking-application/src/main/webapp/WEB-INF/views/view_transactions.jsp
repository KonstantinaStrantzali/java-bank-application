<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@page import="com.ab.entities.Transaction"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

   
  </head>
  <body>
<section class="vh-100 bg-image" style="background-image: url('https://images.unsplash.com/photo-1607944024060-0450380ddd33?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1632&q=80');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
            
<%   List<Transaction> showTransactionList = (List<Transaction>)session.getAttribute("showTransactionList"); %>


 <table class="table" >
  
  <thread>
  
  	<tr>
  	
  		<th scope="col"> Account Number </th>
  		<th scope="col"> Amount </th>
  		<th scope="col"> Balance </th>
  		<th scope="col"> Date Opened </th>
  		
  
  	</tr>
  	
  </thread>
  <tbody>
  	<c:forEach items="${showTransactionList}" var="c">
		
		<tr>
		
		<td> <c:out value="${c.getAccountNumber()}"/> </td>
		<td> <c:out value="${c.getAmount()}"/> </td>
		<td> <c:out value="${c.getBalance()}"/> </td>
		<td> <c:out value="${c.getDateOfTransaction()}"/> </td>
	
	 </td>
	
		
		<td>
		
			
	
		</td>
	
		</tr>
	
	</c:forEach>
	</tbody>
  
  </table>

  
 </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</section>

  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
  </body>
</html>