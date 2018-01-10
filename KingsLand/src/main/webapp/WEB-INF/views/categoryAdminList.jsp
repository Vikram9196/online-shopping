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
<h2>Category List for Admin</h2>
<table class="table table-hover" id="acl" class="display" border="2" width="80" align="center">
<tr><th>Sr. No</th>
<th>CID</th>
<th>Category Name</th>
<th class="span2">Action</th>
</tr>

<c:if test="${empty catList }">
<tr>
<td colspan="10" align="center">No Record Exists!!</td>
</tr>
</c:if>
<c:forEach varStatus="st" var="p"  items="${catList}">
<tr>
<td><c:out value="${st.count }"></c:out></td>
<td><c:out value="${p.cid }"></c:out></td>
<td><c:out value="${p.categoryName }"></c:out></td>
<td class="span4"><c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<a role="button" class="btn btn-info"  href="#">Edit</a>
<a class="btn btn-danger" role="button" href="#">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>