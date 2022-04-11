<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edited film</title>



</head>
<body>
${film}

<form action="editFilm.do" method="POST">
	<input type= "hidden" name="id" value="${film.id}">
      <label for="title">Title:</label>
      <input type="text" name="filmTitle" value="${film.filmTitle}">
      <br>
      <label for="description">Description:</label>
      <input type="text" name="description">
      <br>
      <label for="release_year">Release year:</label>
      <input type="text" name="releaseYear">
      <br>
      Language: <br> <input type="radio" name="languageId" value="1"/>
		<label for="1">English</label>
		<input type="radio" name="languageId" value="2"/>
		<label for="2">Italian</label>
		<input type="radio" name="languageId" value="3"/>
		<label for="3">Japanese</label>
		<input type="radio" name="languageId" value="4"/>
		<label for="4">Mandarin</label>
		<input type="radio" name="languageId" value="5"/>
		<label for="5">French</label>
		<input type="radio" name="languageId" value="6"/>
		<label for="6">German</label>
		<br> 
      <label for="rental_duration">Rental Duration:</label>
      <input type="text" name="rentalDuration" value= "3">
      <br>
      <label for="rental_rate">Rental Rate</label>
      <input type="text" name="rentalRate" value= "4.99">
      <br>
      <label for="length">Length:</label>
      <input type="text" name="filmLength">
      <br>
      <label for="replacement_cost">Replacement Cost:</label>
      <input type="text" name="replacementCost" value="19.99">
      <br>
      Rating: <br> <input type="radio" name="rating" value="G"/>
		<label for="G">G</label>
		<input type="radio" name="rating" value="PG"/>
		<label for="PG">PG</label>
		<input type="radio" name="rating" value="PG13"/>
		<label for="PG13">PG-13</label>
		<input type="radio" name="rating" value="R"/>
		<label for="R">R</label>
      <br>
      <!-- Special Features:
      <br>
		<input type="checkbox" name="specialFeatures" value="Trailers"/>
		<label for="Trailers">Trailers</label>
		<input type="checkbox" name="specialFeatures" value="Deleted Scenes"/>
		<label for="Deleted Scenes">Deleted Scenes</label>
		<input type="checkbox" name="specialFeatures" value="Behind The Scenes"/>
		<label for="Behind The Scenes">Behind The Scenes</label>
		<br> -->
      
      <input type="submit" value="Submit Edits">
    </form>

</body>
</html>