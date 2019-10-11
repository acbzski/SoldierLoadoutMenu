<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loadout Page</title>
</head>
<body>
<form action="NavigationServlet" method="post">
Loadout Name:<input type="text" name="loadoutName"><br />
Soldier Name:<input type="text" name="soldierName"><br />
Soldier Birthdate:<input type="text" name="month" placeholder="mm" size="3">
	<input type="text" name="day" placeholder="dd" size="3">, 
	<input type="text" name="year" placeholder="yyyy" size="4">
Available items:<br />
<select name="allItems" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.description} ${currentitem.weight} oz</option>
</c:forEach>
</select><br />
<input type="submit" value="Add Loadout" name="doThis"> 
</form>
<a href="CreateItems.jsp">Add new items instead</a>
<!-- ********************** VIEWER SECTION **************************** -->
<form method="post" action="NavigationServlet">
<table>
<c:forEach items="${requestScope.allLoadouts}" var="currentloadout">
	<tr><td><input type="radio" name="id" value="${currentloadout.loadout_id}"></td>
		<td><h2>${currentloadout.loadoutName}</h2></td></tr>
	<tr><td colspan="3">Soldier: ${currentloadout.soldier.name}</td></tr>
	<tr><td colspan="3">Soldier Birthdate: ${currentloadout.soldier.birthdate}</td></tr>
	<c:forEach var="listVal" items="${currentloadout.listOfItems}">
		<tr><td></td><td colspan="3">
			${listVal.description} | ${listVal.weight} oz
			</td>
		</tr>
	</c:forEach>
</c:forEach>
</table>
<input type="submit" value="Edit Loadout" name="doThis">
<input type="submit" value="Delete Loadout" name="doThis">
</form>
<a href="index.html">Return to main page</a>
</body>
</html>