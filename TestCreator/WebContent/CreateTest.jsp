<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<h2>Create Test</h2>
		
		<form action="CreateTestServlet" method="post" >
			
			<input type="text" placeholder="nume test" name="numetest">
			
			<input type="text" placeholder="nume autor" name="numneautor">
			<input type="number"  placeholder="numar intrebari" min="1" name="numarintrebari">
			<br/>
			<button type="submit">Create Test </button>
			<button type="reset">Reset</button>
		</form>
		
	
	</div>


</body>
</html>