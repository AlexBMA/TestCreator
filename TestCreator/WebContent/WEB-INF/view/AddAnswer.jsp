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
		<header id="header">
		
			<form action="${pageContext.request.contextPath}/LogOutServlet" method="get">
				<button type="submit">Log out</button>
			</form>
			
			<form action="${pageContext.request.contextPath}/VizualizeazaTeste" method="get">
				<button type="submit">View tests</button>
			</form>
			
		</header>
		<br/>
		<main id="main">
		
		<%
			Test temp =(Test)session.getAttribute("test");
		%>
		<h3> Name test: <%=temp.getTestName() %></h3>
		
		<h4> Name creator:  <%=temp.getCreatorName() %></h4>
				
		<h4>Question:  
			<%=request.getAttribute("textIntrebare").toString() %>
		</h4>
		<form action="${pageContext.request.contextPath}/AdaugaVarianteDeRaspuns" method="post" id="adaugaRaspuns">
			
			<input type="text" value="<%=request.getAttribute("textIntrebare").toString() %>" readonly name="textIntreabare">
			
			<h5>Correct answer/answers: </h5>
			<% int size = Integer.parseInt(request.getAttribute("numarVarianteCorecte").toString());
			   int size2 = Integer.parseInt(request.getAttribute("numarVariante").toString()) - size;
			   
			
				for(int i=0;i<size;i++)
				{%>
					<h4>Correct choice </h4>
			 		<textarea rows="4" cols="30" name="textRaspunsC<%=i%>"  form="adaugaRaspuns">
                		</textarea>
					<br/>
				
				<%}
			%>
			<input type="number" value="<%=size %>" name="numarVarianteCorecte" readonly>
			
			<br/>
			<h5>Incorrect answer/answers: </h5>
			
			<%
				for(int i=0;i<size2;i++)
				{%>
				
				<h4>Incorrect choice </h4>
		 		<textarea rows="4" cols="30" name="textRaspunsI<%=i%>"  form="adaugaRaspuns">
            		</textarea>
				<br/>
			
				<%}
			%>
			
			<input type="number" value="<%=size2 %>" name="numarVarianteIncorecte" readonly>
		
			
			<br/>
			
			<button  type="submit">Add answers </button>
			<button  type="reset">Reset fields</button>
		</form>
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
		
		
	
	
	</div>

</body>
</html>