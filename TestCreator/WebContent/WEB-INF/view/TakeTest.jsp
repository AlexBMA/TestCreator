<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>
<title>Vizualizare teste existente</title>
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
				Test currentTest = (Test)request.getAttribute("test");
				int numberOfQuestions = currentTest.getNumberOfQuestions();
				List<Question> questonList = currentTest.getListQuestions();
				int index = (int)request.getAttribute("currentquestion");
				Question currentQuestion= questonList.get(index);
			%>
			<aside>
			
				<ul>
				<% for(int i=1;i<=numberOfQuestions;i++){
				%>
					<li>
						<form action="${pageContext.request.contextPath}" method="post">
							<input type="number" value="<%=currentQuestion.getId() %>" hidden readonly name="questionid"/>
							<button type="submit">Question: <%=i%></button>
						</form>
					</li>
					<%}%>
				</ul>
			</aside>
			
			<form action="${pageContext.request.contextPath}" method="get">
				<h4>Question text:<%=currentQuestion.getQuestionText() %> </h4>	
				<%	
					List<Answer> listAnswer = currentQuestion.getListAnswersi();
					int numberOfanswers = currentQuestion.getNumberOfAnswers();
					int numberOfCorrectAnswers = currentQuestion.getNumberOfCorrectAnswers();
					for(int i=0;i<=numberOfanswers;i++)	
					{
				%>
				
					
				
				<%
				}
				%>
				
				<button type="submit">Next</button>
				<button type="submit">Back</button>
			</form>
			
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	</div>
</body>
</html>