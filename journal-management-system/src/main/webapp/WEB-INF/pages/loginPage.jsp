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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:url value="/assets/images/background_image.jpg" 
				var="background_image" />
<style>
#loginbackground{
position:absolute;
right:5px;
top:1px;
}


</style>
<script type="text/javascript">
 function setFocus(){
	document.getElementById('username_or_email').focus();
 }
</script>
</head>
<body onload="setFocus()">
<div style="text-align: center; vertical-align: center">
<!--  --
<p>Document Management System is a great place to store your
important documents. It lets you Upload, Search and Download Documents.
</p>
 -->
<s:url var="authUrl" value="/j_spring_security_check" />

<s:url value="/assets/images/folders.jpg" 
				var="folders" />


		<!--  --
		<img src="${folders}" 
		width="370"
				height="150"
				 />
				  -->
<div id="loginbackground">
<img src="${background_image}" 
		width="600"
				height="650"
				 />
	
	</div>			



<form method="post" class="signin" action="${authUrl}">
<table cellspacing="5" border="0" bordercolor="red" class="loginTable">

	<c:if test="${loginErr ne null}">
		<tr>
			<td colspan="2"
				style="height: 30px; text-align: center; font-weight: bold; color: red;">${loginErr}<br />
			</td>
		</tr>
	</c:if>

	<tr>
		<th><label for="username_or_email">Username</label></th>
		<td><input id="username_or_email" name="j_username" type="text"
			style="" /></td>
	</tr>
	<tr>
		<th><label for="password">Password</label></th>
		<td><input id="password" name="j_password" type="password"
			style="" /> <small><a href="public/registration" style="text-decoration:none; color:green">or Registration</a></small></td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td><input id="remember_me" name="_spring_security_remember_me"
			type="checkbox" style="width: 30px;" /> <label for="remember_me"
			class="inline">Remember me</label></td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td><input name="commit" type="submit" value="Sign In"
			class="button" style="width: 100px; color:white; background:#0066FF" /></td>
	</tr>
</table>
</form>

</div>

</body>
</html>