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

<div class="row">
<div class="col-md-4 item-photo">

<img style="max-width:100%; margin-top:30px;" src="${pageContext.request.contextPath }/resources/${product.imgName}"/>
</div>

<div class="col-md-5" style="border:opx solid  gray">
<h3> ${product.productName } </h3>
<h4>${product.description }</h4>
<h4>Price - ${product.price } Rs.</h4>
<h5>Supplier - ${product.supplier.supplierName }</h5>
<div class="section" style="padding-bottom:20px;">


<c:if test="${pageContext.request.userPrincipal.name==null }">
<form action="${pageContext.request.contextPath }/goToLogin" method="post">
<input type="hidden" value="${product.pid }" name="pId"/> 
<input type="hidden" value="${product.price }" name="pPrice"/> 
<input type="hidden" value="${product.productName}" name="pName"/> 
<input type="hidden" value="${product.imgName }" name="imgName"/> 
<label>Qty:</label>
<input type="number" class="form-control" name="pQty" required/><br><br>

<input class="btn btn-warning btn-lg" type="submit" value="Add To Cart">
<h6><span class="glyphicon glyphicon-heart-empty" style="cursor:pointer; color:red;"></span>Wish List</h6> 
</form>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name!=null }">
<form action="${pageContext.request.contextPath }/addToCart" method="post">
<input type="hidden" value="${product.pid }" name="pId"/> 
<input type="hidden" value="${product.price }" name="pPrice"/> 
<input type="hidden" value="${product.productName}" name="pName"/> 
<input type="hidden" value="${product.imgName }" name="imgName"/> 
<label>Qty:</label>
<input type="number" class="form-control" name="pQty" required/><br><br>

<input class="btn btn-warning btn-lg" type="submit" value="Add To Cart">
<h6><span class="glyphicon glyphicon-heart-empty" style="cursor:pointer; color:red;"></span>Wish List</h6> 
</form>
</c:if>
</div>
</div>

<hr>
<div class="col-sm-9">
<h3>Product Details</h3>
<ul class="menu-item">
<li> </li>
<li> </li>
<li> </li>

</ul>


</div>
<br>
<hr>
<h6> We are Authorized company by Indian Government</h6>
</div>
</div>
</body>
</html>