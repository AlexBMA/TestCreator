<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		
		<header></header>
		<br/>
		<main>
			<form action="LoginServlet" method="post">
		
			<input type="text" placeholder="nume utilizator" name="user">
			<input type="password" placeholder="parola" name="pass">
			
			<br/>
			<button type="submit">Logare</button>
			<button type="reset">Resetare camp</button>
			
		</form>
		</main>
		<br/>
		<footer>
		</footer>
		
	
	</div>
</body>
</html>