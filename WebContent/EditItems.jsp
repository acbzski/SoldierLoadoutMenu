<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Item Page</title>
</head>
<body>
<form action="NavigationServlet" method="post">
Description:<input type="text" name="description" value="${itemToEdit.description}">
Weight:<input type="number" name="weight" value="${itemToEdit.weight}">
<input type="hidden" name="id" value="${itemToEdit.id}">
<input type="submit" value="Submit Edited Item" name="doThis">
</form>
<a href="CreateItems.jsp">Go back - I don't want to edit!</a>
</body>
</html>