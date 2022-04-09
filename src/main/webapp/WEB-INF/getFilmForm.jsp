<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>


<html>

<head>

<meta charset="UTF-8">

<title>GET YOUR FILM</title>

</head>

<body>

<div>
		
			<h1>Find your Film</h1>
			
			<p>Please choose what you would like to do</p>
			
			<form action="result.do">
			
				<div class="input-group mb-3">
				
					<input name="${typeOfSearch}" class="form-control"
					
						placeholder="Enter Film ${typeOfSearch}"
						
						aria-describedby="basic-addon2">
						
					<div class="input-group-append">
					
						<button class="btn btn-outline-dark" type="submit">Submit</button>
						
					</div>
				</div>
			</form>
	</div>




</body>
</html>