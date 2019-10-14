<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loadout View/Create Page</title>
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
</head>
<body>
<form action="NavigationServlet" method="post">
<h1>CREATE LOADOUT</h1>
Loadout Name: <input type="text" name="loadoutName"><br />
Soldier Name: <input type="text" name="soldierName"><br />
Soldier Birthdate: <input type="number" name="month" placeholder="M" min="1" max="12">
	<input type="number" name="day" placeholder="D" min="1" max="31">, 
	<input type="number" name="year" placeholder="Y" min="1900" max="2019"><br />
Available equipment:<br />
<select name="allItems" multiple size="5">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.description} ${currentitem.weight} oz.</option>
</c:forEach>
</select><br />
<p>Hold down the Ctrl (Windows) / Command (Mac) button to select multiple options.</p>
<input type="submit" value="Add Loadout" name="doThis"> 
</form><br />
<!-- ********************** VIEWER SECTION **************************** -->
<form method="post" action="NavigationServlet">
<h1>EXISTING LOADOUTS</h1>
<table>
<c:forEach items="${requestScope.allLoadouts}" var="currentloadout">
	<tr><td><input type="radio" name="id" value="${currentloadout.loadout_id}"></td>
		<td><h2 colspan="3">${currentloadout.loadout_name}</h2></td></tr>
	<tr><td colspan="3">Soldier Name: ${currentloadout.soldier.name}</td></tr>
	<tr><td colspan="3">Soldier Birthdate: ${currentloadout.soldier.birthdate}</td></tr>
	<c:forEach items="${currentloadout.listOfItems}" var="listVal">
		<tr><td colspan="3">${listVal.description} - ${listVal.weight} oz.</td></tr>
	</c:forEach>
</c:forEach>
</table>
<input type="submit" value="Edit Loadout" name="doThis">
<input type="submit" value="Delete Loadout" name="doThis">
<input type="submit" value="View Equipment" name="doThis"><br />
</form><br />
<input type="button" onclick="location.href='index.html';" value="Return to Home Page"/>
</body>
</html>