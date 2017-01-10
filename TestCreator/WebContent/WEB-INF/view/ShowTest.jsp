<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>
<title>View test</title>
</head>
<body>
	
	<div id="container">
		<header id="header"></header>
		<br/>
		
		<main id="main">
			<% Test test= (Test)request.getAttribute("test");
			%>		
			
			<h2>Name test: <%=test.getTestName() %> </h2>
			<h2>Author test: <%=test.getCreatorName() %></h2>
			<h2>Questions: <%=test.getListQuestions().size() %></h2>
			
			<ol>
				<%List<Question> questionList = test.getListQuestions();
				 // List<List<Answer>> answerList = (List<List<Answer>>)request.getAttribute("answerlist");
				  for(Question q:questionList)
				  {
				%>
				<li>
					
					<textarea rows="4" cols="30">Question: <%=q.getQuestionText() %></textarea>
					<h4><%=q.getNumberOfAnswers() %></h4>
					<h4><%=q.getNumberOfCorrectAnswers() %></h4>
					<ul>
						<%
							List<Answer> listAnswers = q.getListAnswersi();
						for(Answer a:listAnswers)
							{
							%>
						 
							<li>
								<label><%=a.getAnswerText() %></label>
								<label></label>
							</li>
									
						<%
							}
						%>
					</ul>
				</li>
				<%} %>
			</ol>
			
		</main>
		
		<br/>
		<footer id="footer"></footer>
		
		
		
	
	</div>
	
</body>
</html>