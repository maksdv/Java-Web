<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import='java.util.ArrayList'%>
 <%@ page import='java.util.*' %>
  
 
 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="styles.css">

<meta charset="UTF-8">
<title>Quizz</title>
</head>
<body>
<header class='header'><center><p>SECOND TERM PHP EXAM<p></center></header>
<% 

	//String id= (String)request.getParameter("id");
	//String name = (String)request.getParameter("user");
	String user = (String)session.getAttribute("user");
	ArrayList<String> temas = (ArrayList)session.getAttribute("temas");
	Cookie[] cookies = request.getCookies();
	
	for(Cookie c: cookies){
		out.print(c);
	}
	//out.print(session.getAttribute("temas"));
%>
<br>
<br>
	<center>
		<form action="respuestas">
			<select name='tema'>
			<%
				for(String t : temas){
					out.print("<option value="+t+">"+t+"</option>");
				}
			%>
			</select>
			<button type="submit">Start Quizz</button>
	    </form>
	</center>
<p>Su nombre es: <% out.println(user);%></p>






</body>
</html>