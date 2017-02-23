<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>
</head>
<body>
	<div id="container">
		
		<header id="header">
			
			<nav>
				<ul>
					<li>
						
					</li>
					<li>
						<form action="${pageContext.request.contextPath}/LogOutServlet" method="get">
	
							<button type="submit">Log out</button>
						</form>
					</li>
				</ul>
			</nav>
			
		</header>
		
		<br/>
		<main id="main">
			<%
				TestReport testReport = (TestReport)session.getAttribute("testreport");
				List<Item> listItems = testReport.getTestItems();
				int size = listItems.size();
			%>
			<h2>Score: <%=testReport.getScore()%> out of <%=size %> </h2>
			<br/>
			<ul>
			<%
				for(int i=0;i<size;i++)
				{
					Item localItem = listItems.get(i);
					
			%>
				<h3>Question: <%=localItem.getQuestionText() %></h3>
				<h4>User answer: </h4>
				
					<h3><%=localItem.getAllUserAnswersInAParagraf() %></h3>
				
				
				<h4>Correct answer:</h4>
				
					<h3><%=localItem.getAllCorectAnswerInAParagraf() %></h3>
				
				<br/>
			<%
				}
			%>
			</ul>
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	</div>
</body>
</html>