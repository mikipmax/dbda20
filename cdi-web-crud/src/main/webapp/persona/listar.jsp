<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar personas</title>
</head>
<body>
	<div align="center">
		<h1>Listado de Personas</h1>
		<table border="1">
			<c:forEach var="persona" items="${personas}">
				<tr>
					<td>${persona.id}</td>
					<td>${persona.nombre}</td>
					<td>${persona.direccion}</td>
					<td>${persona.correo}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="${pageContext.request.contextPath}/index.jsp">Regresar</a>
	</div>
</body>
</html>