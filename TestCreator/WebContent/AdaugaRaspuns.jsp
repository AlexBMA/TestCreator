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
		
		<h3> Nume test: <%=request.getAttribute("numeTest") %></h3>
		<h4> Nume autor:  <%=request.getAttribute("autorTest") %></h4>
		<h4> Numar intrebari al testului: <%=request.getAttribute("numarIntrebari") %></h4>
		<h4> Numar intreabare curenta: </h4>
		
		<h5>Intrebare:  </h5>
		<p>
			<%=request.getAttribute("textIntrebare").toString() %>
		</p>
		
		<form action="AdaugaVarianteDeRaspuns" method="post" id="adaugaRaspuns">
			
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
			
			<input type="text" value="<%=request.getAttribute("numeTest")%>" name="numeTest" readonly>
			<input type="text" value="<%=request.getAttribute("autorTest") %>" name="numeAutor" readonly>
			<input type="text" value="<%=request.getAttribute("numarIntrebari") %>" name="numarIntrebari" readonly>
			
			
			
			<br/>
			
			<button  type="submit">Adauga raspunsurile </button>
			<button  type="reset">Reseteaza campurile</button>
		</form>
		
		
	
	
	</div>

</body>
</html>