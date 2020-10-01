<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>Listar personas</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/index.jsp">HOME</a>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

				<li class="nav-item"><a class="nav-link "
					href="${pageContext.request.contextPath}/test">LISTAR</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/persona/crear.jsp">CREAR</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/persona/actualizar.jsp">ACTUALIZAR</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/persona/eliminar.jsp">ELIMINAR</a></li>
			</ul>
	
		</div>
	</nav>

	<br>

	<h1 class="text-center">Listado de Personas</h1>
	<table class="table">
		<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Direcci�n</th>
					<th scope="col">E-mail</th>
				</tr>
			</thead>
		<c:forEach var="persona" items="${personas}">
		
			<tbody>
				<tr>
					<td>${persona.id}</td>
					<td>${persona.nombre}</td>
					<td>${persona.direccion}</td>
					<td>${persona.correo}</td>
				</tr>
			<tbody>
		</c:forEach>
	</table>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>