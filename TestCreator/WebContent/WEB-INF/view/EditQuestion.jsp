<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"  type="text/css"/>
<title>Edit test</title>
</head>
<body>
	<div id="container">
	
		<header id="header">
			
		<form action="${pageContext.request.contextPath}/MakeNewTestServlet" method="get">
		
			<button type="submit">Make new test</button>
		</form>
		
	
		<form action="${pageContext.request.contextPath}/VizualizeazaTeste" method="get">
	
			<button type="submit">View tests</button>
		</form>	
		
		<form action="${pageContext.request.contextPath}/LogOutServlet" method="get">
	
			<button type="submit">Log out</button>
		</form>
		</header>
		<br/>
		<main id="main">
			<%Question question = (Question)request.getAttribute("question"); 	
			%>
			<form action="${pageContext.request.contextPath}" method="post" id="editquestion">
			<h2>Question text:</h2>
			<textarea rows="3" cols="40" name="textIntrebare" form="editquestion">
				 <%=question.getQuestionText()%>
                </textarea>
                <br/>
			<%
				int size = question.getNumberOfAnswers();
				List<Answer> listAnswers = question.getListAnswersi();
				for(int i=0;i<size;i++){	
					Answer answer = listAnswers.get(i);
			%>
			<label>Answer <%=i+1%>:</label>
			<input type="text" value="<%=answer.getAnswerText()%>"name="answertext<%=i+1%>">
			<%if(answer.getTrueFalse()==1){ %>
				<input type="radio" value="true" name="answer<%=i+1%>" checked>True
				<input type="radio" value="false" name="answer<%=i+1%>" >False
				<%} %>
			<%if(answer.getTrueFalse()==0){%>
				<input type="radio" value="true" name="answer<%=i+1%>" >True
				<input type="radio" value="false" name="answer<%=i+1%>"checked >False
					
			<%} %>	
			<br/>
			
			
			<%}%>
				<button type="submit">Save modifications</button>
				<button type="reset">Reset Fields</button>
			</form>
			
		</main>
		<br/>
		<footer id="footer">
		
		</footer>
		</div>
</body>
</html>