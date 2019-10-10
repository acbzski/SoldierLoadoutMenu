<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "editItemServlet" method="post">
Soldier: <input type ="text" name = "store" value= "${itemToEdit.description}">
Birthdate: <input type = "text" name = "item" value= "${itemToEdit.weight}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Edit Item" name = "doThis">
</form>

</body>
</html>