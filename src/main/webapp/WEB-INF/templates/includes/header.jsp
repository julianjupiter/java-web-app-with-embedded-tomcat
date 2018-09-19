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