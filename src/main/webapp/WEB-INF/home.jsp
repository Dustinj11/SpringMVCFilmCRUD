<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

<div class="container mx-auto d-flex flex-column vh-100 w-75 mx-auto text-center justify-content-center">
		<div class="w-50 mx-auto border p-4 form-border">
		
			<h1>Film MVC Project</h1>
			
			<p>Please choose what you would like to do</p>
			
			<form action="userChoice.do" >
			
				<label for="userOption"> <select name="userOption"
				
					class="form-select form-select-lg">
					
						<option value="filmID">Find Film By ID</option>
						
						<option value="filmKeyword">Find Film By Keyword</option>
						
						<option value="addFilm">Add New Film</option>
						
				</select>
				
				</label> <input type="submit" class="btn btn-outline-dark mt-1" value="Begin" />
				
			</form>
		</div>
	</div>




</body>
</html>