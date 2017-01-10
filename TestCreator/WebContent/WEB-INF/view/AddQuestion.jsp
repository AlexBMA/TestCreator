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
	</header>
	<br/>
	<main id="main">
	
		<%
			Test temp =(Test)session.getAttribute("test");
		%>
		<h3> Name test: <%=temp.getTestName() %></h3>
		
		<h4> Name creator:  <%=temp.getCreatorName() %></h4>
		<h4> Number of questions: <%=temp.getListQuestions().size() %></h4>
			
		<h4><%=request.getAttribute("") %></h4>
			
		<br/>	
		<form action="${pageContext.request.contextPath}/AdaugaTextIntrebareSiNrRaspunsi" method="post" id="adaugaIntrebare">

	
			<h4>Question text</h4>
			 <textarea rows="4" cols="30" name="textIntrebare" form="adaugaIntrebare">
                </textarea>
			<br/>
			
			<label>Number of answers min 2</label>
			<input type="number" min="2" name="numarVariante">
			<br/>
			<label>number of correct answers min 1</label>
			<input type="number"  name="numarVarianteCorecte" min="1">
			<br/>
			
			<button type="submit">Add question</button>
			<button type="reset">Reset text</button>
			<br/>
			
		</form>
		<br/>
		<form action="${pageContext.request.contextPath}/FinalizeazaTest" method="post">
			
			
			
			<button type="submit">Finalize test</button>
		
		</form>
		
		<br/>		
	</main>
	<br/>
	<footer id="footer">
	</footer>
	</div>


</body>
</html>