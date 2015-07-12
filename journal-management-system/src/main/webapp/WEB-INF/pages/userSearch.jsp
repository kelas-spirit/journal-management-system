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
<title>User search</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


<table width="500" border="0" >
	<tr style="font-weight: bold; background-color: #321900; color: #FFFFFF;">
		<td>User Id</td>
		<td width="">User Name</td>
		<td width="">First Name</td>
		<td width="">Last Name</td>
		<td width="175">Coupon</td>
		
		<!-- <td width="75">Enabled</td>-->
	</tr>
	<c:forEach items="${usq}" var="user" varStatus="status" >
		<c:choose>
			<c:when test="${status.count mod 2 eq 0}">
				<c:set var="rowcolor" value="even" />
			</c:when>
			<c:otherwise>
			<c:set var="rowcolor" value="odd"/>
			</c:otherwise>
		</c:choose>
		<c:if test="${status.count < 2}">
		<tr class="${rowcolor}">
			<td>${user.userId}</td>
			<td>${user.username}</td>
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			
			<td>
			<form method="POST" id="show" action="couponsend">
				<input type="hidden" name="userId" value="${item.userId}"/>
			</form>
			<button type="submit" form="show" class="btn btn-link">Send coupon</button>
			</td>
		<!-- 	<td><c:forEach items="${user.userRoles}" var="role">
				${role.authority}<br/>
			</c:forEach></td> -->
			
		</tr>
		</c:if>
	</c:forEach>
	
</table>


</body>
</html>