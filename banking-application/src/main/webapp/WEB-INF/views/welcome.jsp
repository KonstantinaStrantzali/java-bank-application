 <%@page import="com.ab.entities.AccountHolder"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!doctype html>
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
             
<% AccountHolder a = (AccountHolder)session.getAttribute("loggedInCustomer"); %>
 <h2 class="text-uppercase text-center mb-5">Welcome to your account<%= " " + a.getUsername() + "!" %> </h2>
    
    <table class="table">
  
  <thread>
  
  	<tr>
  	
  		<th scope="col">  Name </th>
  		<th scope="col"> Last Name </th>
  		<th scope="col"> Username </th>
  		<th scope="col"> Email </th>
  	</tr>
  	
  </thread>
  <tbody>
  <tr>
   
   
<td><%=  a.getFirstname()   %> </td>

<td> <%=  a.getLastname()   %> </td>
<td>  <%=  a.getUsername()   %> </td>
<td> <%=  a.getEmail()   %> </td> 
</tr>
</tbody>
</table>
<br> 
<p> Create Current Account or Savings Account </p>

	<form action="/createCurrentAccount" method="POST">
	
		Current Account Name : <input type="text" name="accountName" /> 
	    
	    <input type="submit" class="btn btn-primary registerbtn"  value="Create Current Account"/>
	   
	</form>
	
	<br><br>
	
	<form action="/createSavingsAccount" method="POST">
	
	<div>
	
		Saving Account Name : <input type="text" name="accountName" /> 
	    
	    <input type="submit" class="btn btn-primary registerbtn"  value="Create Savings Account"/>
	  </div> 
	</form>

  View your Existing Accounts <a href = "accounts"> Here! </a> <br>
  View your Saving Accounts <a href = "saving_accounts"> Here! </a> <br>
             

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







