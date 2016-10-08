<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h2> Test creat </h2>
		<h3> Nume test: <%=request.getAttribute("numeTest") %></h3>
		<h4> Nume autor:  <%=request.getAttribute("autorTest") %></h4>
		<h4> Numar intrebari al testului: <%=request.getAttribute("numarIntrebari") %></h4>
		
		<br/>
		<form action="" method="get">
			
			
			<button>Vizualizeaza intrebari existente</button>
			
		</form>
		<br/>
		
		<form action="AdaugaIntrebareServlet" method="post">
		
			<input type="text" value="<%=request.getAttribute("numeTest")%>" name="numeTest" readonly >
			<br/>
			<button>Adauga intrebare</button>
			
		</form>
		
		
	
	</div>

</body>
</html>