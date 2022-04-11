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


	<c:choose>
	<c:when test="${! empty films}">
	<ul>
	<c:forEach var="f" items="${films}">
	<li>${f.filmTitle} <a href="editFilm.do?filmId=${f.id}">edit</a></li>
	</c:forEach>
	</ul>
	
	</c:when>
	
	<c:otherwise>
	<h2>No film found with that keyword</h2>
	</c:otherwise>
	</c:choose>
	
	<input type="button" onclick="location.href='index.html';" value="Home" />

</body>
</html>