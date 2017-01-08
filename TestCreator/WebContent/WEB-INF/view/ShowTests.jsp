<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/main.css"  type="text/css"/>
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
						Iesire
					</li>
				</ul>
			</nav>
			
		</header>
		
		<br/>
		<main id="main">
		<h2>Toate testele care au fost create</h2>
		
		<table>
			<thead>
				<tr>
					<td>Nume Test</td>
					<td>Autor</td>
					<td>Numar intrebari</td>
					<td>Optiuni</td>
				</tr>
			</thead>
			<tbody>
				<%	
					LinkedHashMap<String,Test> toateTestele = (LinkedHashMap)request.getAttribute("toateTestele");
					int size = toateTestele.size();
					Set<String> keys = toateTestele.keySet();
					Test testTemp;
					for(String key: keys)
					{	
						testTemp = toateTestele.get(key);
						%>
						<tr>
						<td><%=key %></td>
						<td><%=testTemp.getCreatorName() %></td>
						<td><%=testTemp.getNumberOfQuestions() %></td>
						<td>
							<form action="" method="post"> 
							<input type="text" value="<%=key %>" readonly>
							<button type="submit">Edit Test</button> 
							</form>	
							
							<form action="" method="post">
							<input type="text" value="<%=key %>" readonly>
							<button type="submit">Delete Test</button>
							</form>
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