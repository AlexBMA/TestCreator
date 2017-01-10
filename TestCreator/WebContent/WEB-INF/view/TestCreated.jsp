<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
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
		<%
				Test temp =(Test)session.getAttribute("test");
		%>
			<h2> Test created </h2>
			
		<h3> Name test: <%=temp.getTestName() %></h3>
		<h4> Name creator:  <%=temp.getCreatorName() %></h4>
		<h4> Number of questions: <%=temp.getListQuestions().size() %></h4>
		
		<br/>
		<form action="${pageContext.request.contextPath}/" method="get">
			
			
			<button>Vizualizeaza intrebari existente</button>
			
		</form>
		<br/>
		
		<form action="${pageContext.request.contextPath}/AdaugaIntrebareServlet" method="post">
			<button>Add question</button>	
		</form>
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
		
		
	
	</div>

</body>
</html>