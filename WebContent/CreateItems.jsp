<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Equipment Create/View Page</title>
<style>
body{
 background-image:url(https://i.imgur.com/j8Hd5eh.jpg?1);
 background-size:cover;
 color:white;
 text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
 text-align: center;
 font-family: sans-serif;
}
h1{
 font-family: 'Octin Spraypaint', sans-serif;
 font-size: 300%;
}
form{
 border:5px solid white;
 border-radius: 20px;
}
a, a:visited{
 color:white;
 background-color:black;
 border-radius:5px;
 text-decoration:none;
 font-family:sans-serif;
 border:2px solid white;
}
</style>
</head>
<body>
<form action="NavigationServlet" method="post">
<h1>CREATE EQUIPMENT</h1>
Description: <input type="text" name="description">
Weight: <input type="number" name="weight"> oz.
<input type="submit" value="Add Item" name="doThis">
</form><br />
<!-- ******************************** LIST VIEWER **************************** -->
<form method="post" action="NavigationServlet">
<h1>EXISTING EQUIPMENT</h1>
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
	<td><input type="radio" name="id" value="${currentitem.id}"></td>
	<td>${currentitem.description}</td>
	<td>${currentitem.weight} oz.</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Edit Item" name="doThis">
<input type="submit" value="Delete Item" name="doThis">
</form><br />
<a href="index.html">Return to main page</a>
</body>
</html>