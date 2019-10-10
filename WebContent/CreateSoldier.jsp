<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="NavigationServlet" method="post">
		Soldier: <input type="text" name="name"> 
		Birthdate: <input type="date" name="birthdate"> 
		<input type="submit" value="AddSoldier">
	</form>

	

</body>
</html>