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
						Creaza test
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
		<h2>All test available </h2>
		
		<table>
			<thead>
				<tr>
					<th>Name test</th>
					<th>Author test</th>
					<th>Questions</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
				<%	
					List<Test> testList = (List)request.getAttribute("testlist");
					
					User user = (User)session.getAttribute("user");
					int userId = user.getId();
					for(Test temp: testList)
					{	int size = temp.getNumberOfQuestions();
						
						%>
						<tr>
						<td><%=temp.getTestName() %></td>
						<td><%=temp.getCreatorName() %></td>
						<td><%=size%></td>
						<td>		
							<form action="${pageContext.request.contextPath}/ViewTestServlet" method="get">
							<input type="number" readonly hidden value="<%=temp.getId() %>" name="testid"/>
							<button type="submit">View Test</button> 
							</form>
							
							<%if(userId==temp.getUserId()) 
								{
							%>
							<form action="${pageContext.request.contextPath}/" method="post"> 
							<input type="number" readonly hidden value="<%=temp.getId() %>" name="testid"/>s
							<button type="submit">Edit Test</button> 
							</form>	
							
							<form action="${pageContext.request.contextPath}/" method="post">
							<input type="number" readonly hidden value="<%=temp.getId() %>" name="testid"/>
							<button type="submit">Delete Test</button>
							</form>
							<%
								}
							%>
							
						</td>
					</tr>
				<% }%>
				
				
				
			</tbody>
		
		</table>
		</main>
		<br/>
		<footer id="footer">
		</footer>
		
	
	</div>
	
</body>
</html>