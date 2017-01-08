<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>

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
			<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		
			<input type="text" placeholder="nume utilizator" name="user">
			<input type="password" placeholder="parola" name="pass">
			
			<br/>
			<button type="submit">Log in</button>
			<button type="reset">Reset fields</button>
			
			
			
		</form>
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	</div>
</body>
</html>