<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Kings' Land</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
	 <div class="container">
 <h2>Registration form</h2>
 <div class="col-lg-12">
 <div class="row">
<form:form modelAttribute="user" action="${pageContext.request.contextPath }/saveRegister" method="post">
 
  <form:errors path="email" cssClass="error"/>
 <div class="form-group">
 <label>Email:</label><br>
 <form:input  type="email" path="email" class="form-control" placeholder="enter email"/>
 </div>
 <form:errors path="password" cssClass="error"/>
 <div class="form-group">
 <label>Password:</label><br>
 <form:input type="password" path="password" class="form-control" placeholder="enter password"/>
 </div>
 <form:errors path="name" cssClass="error"/>
 <div class="form-group">
 <label>Name:</label><br>
 <form:input type="text" path="name" class="form-control" placeholder="enter  name"/>
 </div>
<form:errors path="address" cssClass="error"/>
 <div class="form-group">
 <label>Address:</label><br>
 <form:input  type="text" path="address" class="form-control" placeholder="enter address"/>
 </div>
 <form:errors path="phone" cssClass="error"/>
 <div class="form-group">
 <label>Mobile Number:</label><br>
 <form:input type="number" path="phone" class="form-control" placeholder="enter number"/>
 </div>
 
 <br><br>
 
 <button type="submit" class="btn btn-lg btn-info">Register</button>
 <button type="reset" class="btn btn-lg btn-danger">Cancel</button>
 
 </form:form>
 
 </div>
 </div>
 </div>
 


</body>
</html>