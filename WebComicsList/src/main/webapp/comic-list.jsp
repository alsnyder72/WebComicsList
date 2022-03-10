<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Comics List View Page</title>
</head>
<body>

   <form method = "post" action = "navigationServlet">
	<table width = "25%" cellspacing = "1" cellpadding = "2" border = "2">
		<caption align=top><h2>Current Registered Comic List</h2></caption><br />
		<tr><td></td>
		<td>Publisher</td>
		<td>Title</td>
		<td>Volume</td>
		<td>Issue</td>
		</tr>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
			<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.publisher}</td>
			<td>${currentitem.title}</td>
			<td>${currentitem.volume}</td>
			<td>${currentitem.issue}</td>
			</tr>
		</c:forEach>
	</table><br /><br />
	<input type = "submit" value = "edit" name="doThisToItem">
	<input type = "submit" value = "delete" name="doThisToItem">
	<input type="submit" value = "add" name = "doThisToItem">
   </form>
</body>
</html>