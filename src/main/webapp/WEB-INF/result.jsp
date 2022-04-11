<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Film Display</title>
<link rel="stylesheet" href="css/style.css"/>

</head>
<body>

	<h1>Film Display</h1>
	<c:choose>
		<c:when test="${! empty film }">
			<ul>
				<li>Title: ${ film.filmTitle}</li>
				<li>Description: ${ film.description}</li>
				<li>Release Year: ${ film.releaseYear}</li>
				<li>${ film.languageId}</li>
				<li>Rental Duration: ${ film.rentalDuration}</li>
				<li>Rental Rate: ${ film.rentalRate}</li>
				<li>Film Length: ${ film.filmLength}</li>
				<li>Replacement Cost: ${ film.replacementCost}</li>
				<li>Rating: ${ film.rating}</li>
				<li>Special Features: ${ film.specialFeatures}</li>
				<li>Cast: ${ film.cast}</li>
				<li>Category: ${ film.catagory}</li>
				<li>Language: ${ film.language}</li>
				

			</ul>
			
				
					<c:choose>
	
			<c:when test="${film.id <= 1000}">
				<br>
				<br>
				Cannot delete this film
			</c:when>
	
			<c:otherwise> 
			<a href="deleteFilm.html">Delete this film</a><br>
			</c:otherwise>

	</c:choose>


		</c:when>
		<c:otherwise>
			<p>No film found</p>
			<br>
			<p>Please try again</p>


		</c:otherwise>

	</c:choose>

</body>
</html>