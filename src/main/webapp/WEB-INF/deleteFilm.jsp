<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deleted film</title>



</head>
<body>

  <c:choose>
    <c:when test= "true">
      Your film has been deleted
    </c:when>
    <c:otherwise>
    Try again
  </c:otherwise>
  </c:choose>


</body>
</html>