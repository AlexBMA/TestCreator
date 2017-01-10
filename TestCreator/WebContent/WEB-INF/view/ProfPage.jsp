<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>
<title>Pagina principala profesor</title>
</head>
<body>
	<div id="container">
		
		<header id="header">
		</header>
		<br/>
		<main id="main">
		
		<form action="${pageContext.request.contextPath}/MakeNewTestServlet" method="get">
		
			<button type="submit">Creaza test nou</button>
		</form>
		
	
		<form action="${pageContext.request.contextPath}/VizualizeazaTeste" method="get">
	
			<button type="submit">Vizualizare teste</button>
		</form>
	
			
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	</div>
	
	
	
	
	

</body>
</html>