<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Equipment Edit Page</title>
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
</style>
<script>
function goBack(){
 window.history.back();
}
</script>
</head>
<body>
<form action="NavigationServlet" method="post">
<h1>EDIT EQUIPMENT</h1>
Description: <input type="text" name="description" value="${itemToEdit.description}">
Weight: <input type="number" name="weight" value="${itemToEdit.weight}"> oz.
<input type="hidden" name="id" value="${itemToEdit.id}">
<input type="submit" value="Submit Edited Item" name="doThis"><br />
</form>
<button onclick="goBack()">Go back - I don't want to edit!</button>
</body>
</html>