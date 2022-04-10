<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Keyword films</title>
</head>
<body>

<h1>Films:</h1>

		<c:forTokens items = "${film}" var = "f">
         <c:out value = "${f.title}"/><p>
      </c:forTokens>

</body>
</html>