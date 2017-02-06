<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>
<title>Insert title here</title>
</head>
<body>

	<div id="container">
		
		<header id="header">
			
			<form action="${pageContext.request.contextPath}/VizualizeazaTeste" method="get">
	
				<button type="submit">View tests</button>
			</form>
			
			<form action="${pageContext.request.contextPath}/LogOutServlet" method="get">
	
				<button type="submit">Log out</button>
			</form>
		
		</header>
		<br/>
		<main id="main">
		
		<h2>Creeaza test</h2>
		
		<form action="${pageContext.request.contextPath}/CreateTestServlet" method="post" >
			
			<input type="text" placeholder="test name" name="numetest">
			<input type="text" placeholder="test author" name="numeautor">
			<br/>
			<button type="submit">Create Test </button>
			<button type="reset">Reset</button>
		</form>
		
	
			
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	
		
	
	</div>


</body>
</html>