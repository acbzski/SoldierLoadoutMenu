<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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