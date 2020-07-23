<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar personas</title>
</head>
<body>
<div align="center">
<h1>Actualización de Personas</h1>
<hr/>
	<form action="${pageContext.request.contextPath}/test?op=2"
		method="POST">
			<label for="id">Id</label> <input type="number" name="id" required><br />
			<br /> <label for="nombre">Nombre</label> <input type="text"
				name="nombre"><br />
			<br /> <label for="direccion">Direccion</label> <input type="text" name="direccion"><br />
			<br /> <label for="correo">Email</label> <input type="email"
				name="correo"> <br /><br />
			<button type="submit">Actualizar</button>
			<br />
		
		
		
	</form>
	<br />
	<a href="${pageContext.request.contextPath}/index.jsp">Regresar</a>
	</div>
</body>
</html>