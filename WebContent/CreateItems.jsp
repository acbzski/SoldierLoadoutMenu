<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="NavigationServlet" method="post">
		Description: <input type="text" name="description">
		 Weight: <input type="date" name="weight"> 
		 <input type="submit" value="Add Item" name = "doThis">
	</form>

	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<tr>
					<td><input type="radio" name="id" value="${currentitem.id}"></td>
					<td>${currentitem.description}</td>
					<td>${currentitem.weight}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit Item" name="doThis"> <input
			type="submit" value="Delete Item" name="doThis">
	</form>

</body>
</html>