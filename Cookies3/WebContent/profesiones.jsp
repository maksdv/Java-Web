<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.Cookie" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFESIONESc</title>
</head>
<body>
	<%
		String profesion = request.getCookies()[0].getValue();
		int visitas = Integer.parseInt(request.getCookies()[1].getValue());
		 
		 out.println("html"); 	
	%>

	<form action="CookArray" method="post">
		
		Nombre usuario <input type="text" name="usu"><br><br>
		Contraseña <input type="password" name="pass"><br>
		
		<br><input type="submit" name= "env" value="Enviar">
	</form><br>
	
	
</body>
</html>