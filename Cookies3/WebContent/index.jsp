<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario-basic</title>
</head>
<body>
	<%
		if(request.getParameter("error") != null){
			out.println("<h1 style='background-color: red; color:white;'> USUARIO NO ENCOTRADO</h1>");
		}
	%>

	<form action="CookArray" method="post">
		
		Nombre usuario <input type="text" name="usu"><br><br>
		Contraseña <input type="password" name="pass"><br>
		
		<br><input type="submit" name= "env" value="Enviar">
	</form><br>
	
	
</body>
</html>
