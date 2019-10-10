<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "editExistingListServlet" method="post">
Trip Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
Trip date: <input type ="text" name = "month" placeholder="mm" size="4" value="${listToEdit.tripDate.getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="4" value="${listToEdit.tripDate.getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${listToEdit.tripDate.getYear()}">
Traveler Name: <input type = "text" name = "shopperName" value="${listToEdit.shopper.shopperName}"><br />
<input type = "hidden" name = "id" value="${listToEdit.id}">
Current Destinations:<br />
<select name="currentItems" multiple size="6">
<c:forEach var = "listVal" items = "${listToEdit.listOfItems}">
          <option value = "${listVal.id}">${listVal.store} | ${listVal.item}</option>          
  </c:forEach>
</select>
<br />
Remaining Destinations:<br />
<select name="itemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItemsToAdd}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.store} | ${currentitem.item}</option>
</c:forEach>
</select>

<br />
<input type = "submit" value="Edit List" name = "doThis">
</form>

</body>
</html>