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
	<header id="header">
	</header>
	<br/>
	<main id="main">
	
		<h3>
			Nume test:
			<%=request.getAttribute("numeTest")%></h3>
		<h4>
			Nume autor:
			<%=request.getAttribute("numeAutor")%></h4>
		<h4>
			Numar intrebari al testului:
			<%=request.getAttribute("numarIntrebari")%></h4>
			
		<h4><%=request.getAttribute("") %></h4>
			
		<br/>	
		<form action="AdaugaTextIntrebareSiNrRaspunsi" method="post" id="adaugaIntrebare">

	
			<h4>Textul intrebarii</h4>
			 <textarea rows="4" cols="50" name="textIntrebare" form="adaugaIntrebare">
                </textarea>
			<br/>
			
			<input type="number" placeholder="numar de variante" min="2" name="numarVariante">
			<input type="number" placeholder="numar de variante corecte" name="numarVarianteCorecte" min="1">
			<br/>
			
			<button type="submit">Adauga Intrebare</button>
			<button type="reset">Reseteaza text</button>
			<br/>
			<input type="text" readonly value="<%=request.getAttribute("numeTest")%>" name="numeTest">
			<input type="text" readonly value="<%=request.getAttribute("numeAutor")%>" name="numeAutor">
			<input type="text" readonly value="<%=request.getAttribute("numarIntrebari")%>" name="numarIntrebari">
			
		</form>
		<br/>
		<form action="FinalizeazaTest" method="post">
			
			<input type="text" readonly value="<%=request.getAttribute("numeTest")%>" name="numeTest">
			
			<button type="submit">Finalizeaza test</button>
		
		</form>
		
		<br/>		
	</main>
	<br/>
	<footer id="footer">
	</footer>
	</div>


</body>
</html>