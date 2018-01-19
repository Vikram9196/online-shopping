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


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class="container"><br>
<h2>WELCOME TO LOGIN PAGE!!!</h2>
<form action="${pageContext.request.contextPath }/login" class="form-signin" method="post">

<h3><label>Email:</label></h3>
<input type="text" name="username" class="login-box" required>

<h3><label>Password:</label></h3>
<input type="password" name="password" class="login-box" required>
<br><br>

<button class="btn btn-lg btn-primary" type="submit">LOGIN</button>
<button class="btn btn-lg btn-warning" type="reset">CANCEL</button>
</form>
</div>
</body>
</html>