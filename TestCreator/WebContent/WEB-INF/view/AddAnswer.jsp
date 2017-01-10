<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<header id="header"></header>
		<br/>
		<main id="main">
		
		<%
			Test temp =(Test)session.getAttribute("test");
		%>
		<h3> Name test: <%=temp.getTestName() %></h3>
		
		<h4> Name creator:  <%=temp.getCreatorName() %></h4>
		<h4> Number of questions: <%=temp.getListQuestions().size() %></h4>
		
		<h4> Numar intreabare curenta: </h4>
		
		<h5>Intrebare:  </h5>
		<p>
			<%=request.getAttribute("textIntrebare").toString() %>
		</p>
		
		<form action="${pageContext.request.contextPath}/AdaugaVarianteDeRaspuns" method="post" id="adaugaRaspuns">
			
			<input type="text" value="<%=request.getAttribute("textIntrebare").toString() %>" readonly name="textIntreabare">
			
			<h5>Raspunsuri/raspunsuri corecte: </h5>
			<% int size = Integer.parseInt(request.getAttribute("numarVarianteCorecte").toString());
			   int size2 = Integer.parseInt(request.getAttribute("numarVariante").toString()) - size;
			   
			
				for(int i=0;i<size;i++)
				{%>
					<h4>Varianta raspuns corecta </h4>
			 		<textarea rows="4" cols="50" name="textRaspunsC<%=i%>"  form="adaugaRaspuns">
                		</textarea>
					<br/>
				
				<%}
			%>
			<input type="number" value="<%=size %>" name="numarVarianteCorecte" readonly>
			
			<br/>
			<h5>Raspunsuri/raspunsuri incorecte: </h5>
			
			<%
				for(int i=0;i<size2;i++)
				{%>
				
				<h4>Varianta raspuns incorecta </h4>
		 		<textarea rows="4" cols="50" name="textRaspunsI<%=i%>"  form="adaugaRaspuns">
            		</textarea>
				<br/>
			
				<%}
			%>
			
			<input type="number" value="<%=size2 %>" name="numarVarianteIncorecte" readonly>
		
			
			<br/>
			
			<button  type="submit">Adauga raspunsurile </button>
			<button  type="reset">Reseteaza campurile</button>
		</form>
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
		
		
	
	
	</div>

</body>
</html>