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
		<header id="header">
		
		<form action="${pageContext.request.contextPath}/LogOutServlet" method="get">
	
			<button type="submit">Log out</button>
		</form>
		</header>
		<br/>
		
		<main id="main">
			<% Test test= (Test)request.getAttribute("test");
			%>		
			
			<h2>Name test: <%=test.getTestName() %> </h2>
			<h2>Author test: <%=test.getCreatorName() %></h2>
			<h2>Questions: <%=test.getNumberOfQuestions() %></h2>
			
			<ol>
				<%List<Question> questionList = test.getListQuestions();
				  
				 for(Question q:questionList)
				  {	
				%>
				<li>
					
					<h3><%=q.getQuestionText() %></h3>
					<h4>Number of answers: <%=q.getNumberOfAnswers() %></h4>
					<h4>Number of correct answers: <%=q.getNumberOfCorrectAnswers() %></h4>
					
					
						<%
							List<Answer> listAnswers = q.getListAnswersi();
						for(Answer a:listAnswers)
							{
							%>
						 	<br/>
							
								
								<label><% if(a.getTrueFalse()==1) out.print("<b>"+ a.getAnswerText()+" correct"+"</b>"); else out.print(a.getAnswerText()+"  false"); %></label>
							<br/>
									
						<%
							}
						%>
					
				</li>
				<%} %>
			</ol>
			
		</main>
		
		<br/>
		<footer id="footer"></footer>
		
		
		
	
	</div>
	
</body>
</html>