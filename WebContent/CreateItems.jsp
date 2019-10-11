<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loadout Items</title>
</head>
<body>
<form action="NavigationServlet" method="post">
Description: <input type="text" name="description">
Weight (in ounces): <input type="number" name="weight"> 
<input type="submit" value="Add Item" name = "doThis">
</form>
<!-- ******************************** LIST VIEWER **************************** -->
<form method="post" action="NavigationServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>${currentitem.description}</td>
	<td>${currentitem.weight} oz</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Edit Item" name="doThis">
<input type="submit" value="Delete Item" name="doThis">
</form>
<a href="index.html">Return to main page</a>
</body>
</html>