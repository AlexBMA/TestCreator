<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/main.css"  type="text/css"/>
<title>Insert title here</title>
</head>
<body>

	<div id="container">
		
		<header>
		</header>
		<br/>
		<main>
		
		<h2>Creeaza test</h2>
		
		<form action="CreateTestServlet" method="post" >
			
			<input type="text" placeholder="nume test" name="numetest">
			
			<input type="text" placeholder="nume autor" name="numneautor">
			<input type="number"  placeholder="numar intrebari" min="1" name="numarintrebari">
			<br/>
			<button type="submit">Create Test </button>
			<button type="reset">Reset</button>
		</form>
		
	
			
		</form>
		</main>
		<br/>
		<footer>
		</footer>
		
	
	
		
	
	</div>


</body>
</html>