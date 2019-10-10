<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Soldier Page</title>
</head>
<body>
	<form action="NavigationServlet" method="post">
		Soldier: <input type="text" name="name">
		Birthdate:<input type ="text" name = "month" placeholder="mm" size="4">
		  <input type ="text" name = "day" placeholder="dd" size="4">, 
		  <input type ="text" name = "year" placeholder="yyyy" size="4">
		<input type="submit" value="Add Soldier" name = "doThis">
	</form>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allSoldiers}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.soldier}</td>
					<td>${currentitem.birthdate}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit Soldier" name="doThis">
		<input type="submit" value="Delete Soldier" name="doThis">
	</form>
</body>
</html>