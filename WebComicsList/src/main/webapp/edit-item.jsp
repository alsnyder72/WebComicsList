<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Comics Edit Item Page</title>
</head>
<body>
<h2>Edit comic entries here: </h2>
	<form action = "editItemServlet" method="post">
		Publisher: <input type ="text" name = "publisher" value= "${itemToEdit.publisher}">
		Title: <input type = "text" name = "title" value= "${itemToEdit.title}">
		Volume: <input type = "text" name = "volume" value = "${itemToEdit.volume}">
		Issue: <input type = "text" name = "issue" value = "${itemToEdit.issue}">
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>