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
<c:url value="/admin/productUpdate" var="pru"></c:url>
<form method="POST" action="<c:url value="/admin/productUpdate"/>" enctype="multipart/form-data">
<span id="reauth-email" class="reauth-email"></span>

<input type="hidden" name="pId" value="${prod.pid }">
<h4 class="input-title">Product Name</h4>
<input value="${prod.productName }" type="text" name="pName" required>

<h4 class="input-title">Product Description</h4>
<input value="${prod.description }" type="text" name="pDescription" required>

<h4 class="input-title">Product Price</h4>
<input value="${prod.price }" type="text" name="pPrice" required>

<h4 class="input-title">Product Stock</h4>
<input value="${prod.stock }" type="text" name="pStock" required>

<div class="form-group">
<table>
<tr>
<td>Select Supplier</td>
<td>
<select class="form-control" name="pSupplier" required>
<option value="">----Select----</option>
<c:forEach items="${satList}" var="sat">
<option value="${sat.sid }">${sat.supplierName}</option>
</c:forEach>
</select></td></tr>
</table>
</div>

<div class="form-group">
<table>
<tr>
<td>Select Category</td>
<td>
<select class="form-control" name="pCategory" required>
<option value="">----Select----</option>
<c:forEach items="${catList}" var="cat">
<option value="${cat.cid }">${cat.categoryName}</option>
</c:forEach>
</select></td></tr>
</table>
</div>
<div class="fileinput fileinput-new" data-provides="fileinput">
<td>Product Image</td>
<td><input class="form-coontrol" type="file" name="file" accept="image/*"></td>
</div>
<button class="btn btn-lg btn-primary" type="submit">Save</button>
<button class="btn btn-lg btn-warning" type="reset">Cancel</button>
</form>
</div>
</body>
</html>