<%@ include file="/WEB-INF/templates/includes/head.jsp"%>
<%@ include file="/WEB-INF/templates/includes/header.jsp"%>
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
		    	<h1 class="display-4">Java Web Application with Embedded Tomcat</h1>
		    	<p class="lead">This is a web application in Java which runs on embedded Apache Tomcat in the form of executable JAR (not WAR), called uber/fat JAR. Other dependencies, if any, are also included.</p>
		  	</div>
		</div>	
		<main>
			<div class="container">
				<div class="row">
					<div class="col">
						<table class="table table-hover">
							<thead>
							    <tr>
							    	<th scope="col">ID</th>
							      	<th scope="col">Title</th>
							      	<th scope="col">Edition</th>
							      	<th scope="col">ISBN</th>
							      	<th scope="col">Author</th>
							      	<th scope="col">Year Published</th>
							      	<th scope="col">Action</th>
							    </tr>
							</thead>
						  	<tbody>
						  		<c:forEach var="book" items="${books}">
							    <tr>
							      	<th scope="row">${book.id}</th>
							      	<td>${book.title}</td>
							      	<td>${book.edition}</td>
							      	<td>${book.isbn}</td>
							      	<td>${book.author}</td>
							      	<td>${book.yearPublished}</td>
							      	<td>
							      		<div class="btn-group" role="group" aria-label="Basic example">
											<button type="button" id="viewBook" class="btn btn-info" data-toggle="modal" data-target="#bookModal" data-action="viewBook" data-id="${book.id}">View</button>
										  	<button type="button" id="editBook" class="btn btn-success" data-toggle="modal" data-target="#bookModal" data-action="editBook" data-id="${book.id}">Edit</button>
										  	<button type="button" id="deleteBook" class="btn btn-danger" data-toggle="modal" data-target="#bookModal" data-action="deleteBook" data-id="${book.id}">Delete</button>
										</div>
							      	</td>
							    </tr>
							    </c:forEach>
						  	</tbody>
						</table>
					</div>
				</div>
			</div>
		</main>	
		<%@ include file="/WEB-INF/templates/components/bookModal.jsp"%>		
<%@ include file="/WEB-INF/templates/includes/footer.jsp"%>