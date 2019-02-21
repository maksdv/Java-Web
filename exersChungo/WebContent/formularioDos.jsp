<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="validarFdos" method="POST">
	Elija sufruta: <select name="menu" size="3">
	  <option value="sandia" >sandia</option>
	  <option value="manzana">manzana</option>
	  <option value="melon">melon</option>
	  <option value="naranja">naranja</option>
	  <option value="banana">banana</option>
	</select><br><br>
	<input type="number" name="cant" min="0" max="5">
	<input type="submit" name="enter">
	
</form>

</body>
</html>