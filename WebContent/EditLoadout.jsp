<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loadout Edit Page</title>
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
<h1>EDIT LOADOUT</h1>
<input type="hidden" name="id" value="${loadoutToEdit.loadout_id}">
Loadout Name: <input type="text" name="loadoutName" value="${loadoutToEdit.loadout_name}"><br />
Soldier Name: <input type="text" name="soldierName" value="${loadoutToEdit.soldier.name}"><br />
Soldier Birthdate: <input type="text" name="month" placeholder="mm" size="3" value="${loadoutToEdit.soldier.birthdate.getMonthValue()}">
	<input type="text" name="day" placeholder="dd" size="3" value="${loadoutToEdit.soldier.birthdate.getDayOfMonth()}">, 
	<input type="text" name="year" placeholder="yyyy" size="4" value="${loadoutToEdit.soldier.birthdate.getYear()}"><br />
Available items:<br />
<select name="allItems" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.description} ${currentitem.weight} oz.</option>
</c:forEach>
</select><br />
<input type="submit" value="Submit Edited Loadout" name="doThis"> 
</form><br />
<a href="CreateLoadout.jsp">Go back - I don't want to edit!</a>
</body>
</html>