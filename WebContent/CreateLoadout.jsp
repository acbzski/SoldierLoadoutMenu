<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="NavigationServlet" method="post">
		Loadout Name: <input type="text" name="listName"><br />
		Soldier Name: <input type="text" name="shopperName"><br />

		Available items:<br /> <select name="allItemsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.soldier}|
					${currentitem.item}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create Loadout" name = "doThis"> 
	</form>
	<a href="index.html">Go add new Destinations instead.</a>



	<form method="post" action="NavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.listName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Soldier: ${currentlist.soldier.name}</td>
				</tr>
				<c:forEach var="listVal" items="${currentlist.listOfItems}">
					<tr>
						<td></td>
						<td colspan="3">${listVal.soldier}, ${listVal.birthdate}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit list" name="doThis"> <input
			type="submit" value="delete list" name="doThis">

	</form>

	<a href="index.html">Return to main page</a>

</body>
</html>