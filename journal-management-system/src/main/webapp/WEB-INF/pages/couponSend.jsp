<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coupon</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


<form method="POST" id="show" action="couponresult">

Select Category:
<select id="selectedCategory" name="selectedCategory">

				<c:forEach var="category" items="${categorylist}">

                <option value="${category.category_id}">${category.category_name}</option>

            </c:forEach>

</select>
<br><br>
<input type="hidden" name="userId" value="${userId}"/>
Type coupon code: 
<input type="number" name="coupon"/>
</form>

<button type="submit" form="show" class="btn btn-link">Send coupon to user </button>


</body>
</html>