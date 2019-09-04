<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Usuarios</title>
</head>
<body>
	<h1>Crear Usuarios</h1>
	<form action="usuario" method="post">
		<input type="hidden" name="opcion" value="guardar">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><input type="password" name="clave" size="50"></td>
			</tr>
			<tr>
				<td><input type="submit" name="envia" value="Enviar"></td>
				<td><input type="reset" name="restaura" value="Restaurar"></td>
			</tr>
		</table>
	</form>
</body>
</html>