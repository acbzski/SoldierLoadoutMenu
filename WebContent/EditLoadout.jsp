<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Loadout Page</title>
</head>
<body>
<form action="NavigationServlet" method="post">
Loadout Name:<input type="text" name="loadoutName" value="${loadoutToEdit.loadout_name}"><br />
Soldier Name:<input type="text" name="soldierName" value="${loadoutToEdit.soldier.name}"><br />
Soldier Birthdate:<input type="text" name="month" placeholder="mm" size="3" value="${loadoutToEdit.soldier.birthdate.getMonthValue()}">
	<input type="text" name="day" placeholder="dd" size="3" value="${loadoutToEdit.soldier.birthdate.getDayOfMonth()}">, 
	<input type="text" name="year" placeholder="yyyy" size="4" value="${loadoutToEdit.soldier.birthdate.getYear()}">
Available items:<br />
<select name="allItems" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value="${currentitem.id}">${currentitem.description} ${currentitem.weight} oz</option>
</c:forEach>
</select><br />
<input type="submit" value="Submit Edited Loadout" name="doThis"> 
</form>
</body>
</html>