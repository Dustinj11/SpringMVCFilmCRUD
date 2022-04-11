<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This film has been added</title>



</head>
<body>
<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li>Film ID: ${film.id}</li>
				<li>Film Title: ${film.filmTitle}</li>
			</ul>
			<form action="deleteFilm.html" method="POST">
				<input type="hidden" value="${film.id}" name="id"> <input
					type="submit" value="Delete Film">
			</form>

			<form action="editFilm.html" method="POST">
				<input type="hidden" value="${film.id}" name="id"> <input
					type="submit" value="Edit Film">
			</form>
			<br>
		</c:when>

		<c:otherwise>
                <p>Error Film Not Added</p>
            </c:otherwise>
        </c:choose>

</body>
</html>