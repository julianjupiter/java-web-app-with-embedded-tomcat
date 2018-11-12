<%@ include file="init.jsp"%>
<c:if test="${not empty param.pageName}"> 
	<c:set var="pageName" value="${param.pageName}" />
</c:if>
<!doctype html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico">
		<title>${pageName} - Java Web Application with Embedded Tomcat</title>
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/4.1.3/css/bootstrap.min.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
  	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">Java Web Application</a>
			  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
			    	<span class="navbar-toggler-icon"></span>
			  	</button>
			  	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			    	<div class="navbar-nav">
				    	<a class="nav-item nav-link<c:if test="${pageName == 'Home'}"> active</c:if>" href="${pageContext.request.contextPath}/" alt="Home">Home <span class="sr-only">(current)</span></a>
				      	<a class="nav-item nav-link<c:if test="${pageName == 'Books'}"> active</c:if>" href="${pageContext.request.contextPath}/books" alt="Books">Books</a>
			    	</div>
			  	</div>
			</nav>
		</header>