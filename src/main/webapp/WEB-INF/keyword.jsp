<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Keyword films</title>
</head>
<body>

<h1>Films:</h1>

	<ul>
	<c:forEach var="f" items="${films}">
	<li>${f.filmTitle} <a href="editFilm.do?filmId=${f.id}">edit</a></li>
	</c:forEach>
	</ul>

</body>
</html>