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
				
				Test currentTest = (Test)session.getAttribute("test");
				int numberOfQuestions = currentTest.getNumberOfQuestions();
				List<Question> questonList = currentTest.getListQuestions();
				int index = (int)request.getAttribute("currentquestion");
				Question currentQuestion= questonList.get(index);
			%>
			
			
				<ul>
				<% for(int i=0;i<numberOfQuestions;i++){
				%>
					<li>
						<form action="${pageContext.request.contextPath}/SwitchQuestionServlet" method="get">
							<input type="number" value="<%=questonList.get(i).getId() %>" hidden readonly name="questionid"/>
							<button type="submit">Question: <%=i+1%></button>
						</form>
					</li>
					<%}%>
				</ul>
			
			
			<form action="${pageContext.request.contextPath}" method="get">
				<h4>Question:<%=currentQuestion.getQuestionText() %> </h4>	
				<%	
					List<Answer> listAnswer = currentQuestion.getListAnswersi();
					int numberOfanswers = currentQuestion.getNumberOfAnswers();
					int numberOfCorrectAnswers = currentQuestion.getNumberOfCorrectAnswers();
					for(int i=0;i<numberOfanswers;i++)	
					{
					  String textAnswer = listAnswer.get(i).getAnswerText();
					  if(numberOfCorrectAnswers ==1)
						{	
					
				%>
						<input type="radio" value="<%=textAnswer %>" name="radioanswer<%=i%>"/><%=textAnswer %>		
				<%
						}
					if(numberOfCorrectAnswers>1)
						{
				%>
						<input type="checkbox" value="<%=textAnswer %>" name="checkanswer<%=i%>"/><%=textAnswer%>
				
				<%
						}
					}
				%>
				<br/>
				<input type="number" value="<%=index%>" hidden reandonly name="index"/>
				<button type="submit">Next</button>
				
				
			</form>
			
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	</div>
</body>
</html>