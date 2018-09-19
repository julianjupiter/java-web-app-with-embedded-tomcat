<%@ include file="/WEB-INF/templates/includes/head.jsp"%>
<c:set var="pageName" value="Home"/>
<%@ include file="/WEB-INF/templates/includes/head.jsp"%>
<%@ include file="/WEB-INF/templates/includes/header.jsp"%>
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
		    	<h1 class="display-4">Java Web Application with Embedded Tomcat</h1>
		    	<p class="lead">This is a web application in Java which runs on embedded Apache Tomcat in the form of executable JAR (not WAR), called uber/fat JAR. Other dependencies, if any, are also included.</p>
		    	<a type="button" class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/books" alt="Books">Books</a>
		  	</div>
		</div>		
<%@ include file="/WEB-INF/templates/includes/footer.jsp"%>