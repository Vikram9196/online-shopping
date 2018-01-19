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
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
	<div class="container">


		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img class="img-responsive centre block"
						src="<spring:url value="/resources/download.jpg"></spring:url>"
						style="width: 100%;">
				</div>

				<div class="item">
					<img class="img-responsive centre block"
						src="<spring:url value="/resources/download1.jpg"></spring:url>" 
						style="width: 100%;">
				</div>

				<div class="item">
					<img class="img-responsive centre block"
						src='<spring:url value="/resources/download2.jpg"></spring:url>'
						style="width: 100%;">
				</div>
			</div>

			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span></a>
		</div>

	</div>
	<script type="text/javascript">

	$(document).ready(function() {
	    $(".dropdown-toggle").dropdown();
	});

	
	
	</script>
	
                    <jsp:include page="/WEB-INF/views/Footer.jsp"></jsp:include>



</body>
</html>