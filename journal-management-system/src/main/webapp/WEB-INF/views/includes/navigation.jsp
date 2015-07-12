<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.leftNavTabs {
	width: 100%;
	font-size: 12px;
	color: #FFFFFF;
	/*background-color: #321900;*/
	background-color:white;
}

.leftNavTabs td a {
	width: 100%;
	font-size: 12px;
	display: block;
	color: blue;
	background-color: white;
	height: 20px;
	text-align: left;
	vertical-align: middle;
	text-decoration: none;
}

.leftNavTabs td a:HOVER {
	color: white;
	background-color:#00CCFF;
}
</style>

</head>
<body>
<center>Menu</center>
<table class="leftNavTabs" border="0">

	<security:authorize
		access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_COMPANY')">
		<tr height="20">
			<td><s:url value="/index" var="newdoc" /> <a href="${newdoc}">
			All </a></td>
		</tr>
		</security:authorize>
		
		<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_COMPANY')">
		
		<tr height="20">
			<td><s:url value="/upload" var="listdocs" /> <a
				href="${listdocs}">New Journal </a></td>
		</tr>
		<tr>
			<td><s:url value="/users" var="userList" /> <a
				href="${userList}">Users</a></td>
		</tr>

	</security:authorize>
	
	<security:authorize access="hasAnyRole('ROLE_USER')">
	
	<tr height="20">
			<td><s:url value="/subscribed" var="listdocs" /> <a
				href="${listdocs}">Subscribed </a></td>
		</tr>
		
		<tr height="20">
			<td><s:url value="/nosubscribed" var="listdocs" /> <a
				href="${listdocs}">Subscribe Now </a></td>
		</tr>
		
		<tr height="20">
			<td><s:url value="/couponlist" var="listdocs" /> <a
				href="${listdocs}">Coupon </a></td>
		</tr>
	
	</security:authorize>


		
	
		
</table>

</body>
</html>