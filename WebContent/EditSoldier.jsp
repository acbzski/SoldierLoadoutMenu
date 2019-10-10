<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "NavigationServlet" method="post">
Soldier: <input type ="text" name = "store" value= "${itemToEdit.soldier}">
Birthdate: <input type = "text" name = "item" value= "${itemToEdit.birthdate}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Edit Soldier" name = "doThis">
</form>

</body>
</html>