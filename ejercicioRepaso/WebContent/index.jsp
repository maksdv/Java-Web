<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body{
	background-color:#FFC;
}

table{
	background:#FF6;
	padding:10px;
	border:solid 2px #FF0000;
}

td{
	padding:5px 0;
}




</style>
</head>
<body>
<body>
<h1 style="text-align:center">Registro</h1>
<form action="Control" method="post">

  <table width="25%">
    <tbody><tr>
      <td width="13%"><label for="nombre">Nombre: </label></td>
      <td width="87%"><input type="text" name="name" id="name"></td>
    </tr>
    <tr>
      <td><label for="Apellidos">Apellidos  </label></td>
      <td><input type="text" name="apes" id="apes" ></td>
    </tr>
    <tr>
      <td><label for="nota">Nota  </label></td>
      <td><input type="number" name="nota" id="nota"></td>
    </tr>
    <tr>
    </tr>
    <td><label for="asignatura">Asignatura </label></td>
    <td><input type="text" name="asignatura" id="asignatura" ></td>
    <tr>
      <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Enviar"></td>
    </tr>
  </tbody></table>
  <p><br>
  </p>
</form>


</body>
</body>
</html>