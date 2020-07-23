<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eliminar personas</title>
</head>
<body>
<div align="center">
<h1>Eliminación de Personas</h1>
<hr/>
	<form action="${pageContext.request.contextPath}/crud?op=3"
		method="POST">
		<div class="form-group">
			<label for="id">Id</label> <input type="number" name="id" required>
		</div>
		
		<br />
		<button type="submit">Eliminar</button>
		<br />
	</form>
	<br />
	<a href="${pageContext.request.contextPath}/index.jsp">Regresar</a>
	</div>
</body>
</html>