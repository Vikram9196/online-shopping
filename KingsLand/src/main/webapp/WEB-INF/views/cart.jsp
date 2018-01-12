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

<table class="table table-hover" id="cart" class="display" border="2" width="80" align="center">
<tr>
<th>Product Name</th>
<th>Product Quantity</th>
<th>Product Price</th>
<th>Product Image</th>
<th>Sub Total</th>
<th>Action</th>
</tr>

<c:if test="${empty cartInfo }">
<tr>
<td colspan="10" align="center">No Record Exists!!</td>
</tr>
</c:if>
<c:forEach varStatus="st" var="p"  items="${cartInfo}">
<tr>

<td><c:out value="${p.cartProductName}"></c:out></td>
<td><c:out value="${p.cartQuantity}"></c:out></td>
<td><c:out value="${p.cartPrice}"></c:out></td>
<td><img src="${pageContext.request.contextPath }/resources/${p.cartImage}" height="50px" width="50px"></td>
<td><c:out value="${p.cartQuantity * p.cartPrice }"></c:out></td>
<td class="span2">
<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<a class="btn btn-danger" role="button" href="<c:url value="/deletePCart/${ p.cartId}"/>">Delete</a>
</td>
</tr>
<c:set var="gtot" value="${gtot + p.cartPrice*p.cartQuantity }"></c:set>
</c:forEach>
<tr>
<td>


<span class="col-lg-9" align="right"><label>Grand Total : </label><c:out value="${gtot }"></c:out></span>
</td>
</tr>

<tfoot>
<tr>
<td><a class="btn btn-warning btn-lg" href="${pageContext.request.contextPath }/index">Continue Shopping</a></td>
<td><a class="btn btn-success btn-lg" href="${pageContext.request.contextPath }/checkout">Checkout</a></td>
</tr>
</tfoot>
</table>
</div>

</body>
</html>