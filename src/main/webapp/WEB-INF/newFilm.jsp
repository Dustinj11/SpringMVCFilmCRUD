<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New film</title>



</head>
<body>
<ul>
	<c:forEach var="f" items="${films}">
	<li>${f.filmTitle} <a href="editFilm.do?filmId=${f.id}">edit</a></li>
	</c:forEach>
	</ul>

</body>
</html>