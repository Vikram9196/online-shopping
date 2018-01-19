<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Kings' Land</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>

<nav id="navbar-black" class="navbar navbar-inverse navbar-static-top" role="navigation">
 <div class="container-fluid">
    
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navDemo">
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
     
    </button>
    
    <div class="nav navbar-nav">
 
 
 <div class="collapse navbar-collapse" id="navDemo">
 <ul class="nav navbar-nav">
 <li> <a href="${pageContext.request.contextPath }/index">Home</a></li>
 <li><a href="contact"><i class="fa fa-address-book" aria-hidden="true"></i></a></li>
 <c:if test="${pageContext.request.userPrincipal.name==null }">
  					<li><a href="${pageContext.request.contextPath }/goToAdminLogin">Admin</a></li> 
  				</c:if>
  				
  <c:if test="${pageContext.request.userPrincipal.name != null }">				
 <li><a href="${pageContext.request.contextPath }/admin/adding">Admin</a>
 	</li>
 	</c:if>
 
 
 <c:if test="${pageContext.request.userPrincipal.name == null }">	
 <li class="dropdown">
 
 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin List<span class="caret"></span></a>
 
  <ul class="dropdown-menu">
       <li><a href="${pageContext.request.contextPath}/goToAdminLogin">Product</a></li>
       <li><a href="${pageContext.request.contextPath}/goToAdminLogin">Supplier</a></li>
       <li><a href="${pageContext.request.contextPath}/goToAdminLogin">Category</a></li>
  </ul>
</li>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name != null }">
<li class="dropdown">
 
 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin List<span class="caret"></span></a>
 
  <ul class="dropdown-menu">
       <li><a href="${pageContext.request.contextPath}/admin/productList">Product</a></li>
       <li><a href="${pageContext.request.contextPath}/admin/supplierList">Supplier</a></li>
       <li><a href="${pageContext.request.contextPath}/admin/categoryList">Category</a></li>
  </ul>
</li>
</c:if>
 
 
 

<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"
  href="${pageContext.request.contextPath}">Category Choice<span class="caret"></span></a>
     <ul class="dropdown-menu">
    
    <c:forEach var="catVal" items="${catList }">
    
    <li><a href="${pageContext.request.contextPath}/productCustList?cid=${catVal.cid}">${catVal.categoryName}</a></li>
    
    
    
    </c:forEach>
    

    
    </ul>
 
 
 </li>
 </ul>
 
 
 <ul class="nav navbar-nav navbar pull-right">
				<c:if test="${pageContext.request.userPrincipal.name==null }">
   					<li><a href="${pageContext.request.contextPath }/goToRegister">Sign up</a></li>  
  					<li><a href="${pageContext.request.contextPath }/goToLogin">Login</a></li> 
  				</c:if>
  				
  				<c:if test="${pageContext.request.userPrincipal.name != null }">
  					<li><a>Welcome: ${pageContext.request.userPrincipal.name }</a></li>
  					<li><a href="${pageContext.request.contextPath }/logout">Logout</a></li>
  					<li><a href="${pageContext.request.contextPath }/goToCart">My Cart
  					<i class="fa fa-cart-plus" aria-hidden="true"></i></a></li>
  				</c:if>
    				
    				
    			</ul>
 </div>
 
 </div>
 
 </div>
</nav>


</body>
</html>