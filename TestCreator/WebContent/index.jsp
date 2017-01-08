<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/main.css"  type="text/css"/>

<title>Login Page</title>
</head>
<body>
	<div id="container">
		
		<header id="header">
			<a href=""><button>Acasa</button></a>
			<a href=""><button>Despre</button></a>
		</header>
		<br/>
		<main id="main">
			<form action="LoginServlet" method="post">
		
			<input type="text" placeholder="nume utilizator" name="user">
			<input type="password" placeholder="parola" name="pass">
			
			<br/>
			<button type="submit">Logare</button>
			<button type="reset">Resetare camp</button>
			
			
			
		</form>
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	</div>
</body>
</html>