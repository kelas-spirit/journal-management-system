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
<s:url value="/assets/images/folder.png" 
				var="add_folder" />

<s:url value="/assets/images/dms_image.png" 
				var="folder" />
<s:url value="/assets/images/public_folder.png" 
				var="public_folder" />
<s:url value="/assets/images/add_file_25x25.png" 
				var="add_file" />
				
<s:url value="/assets/images/submit.png" 
				var="submit" />

<s:url value="/assets/js/dialog_box.js" 
				var="dialog_box" />
<s:url value="/assets/js/popup-file.js" 
				var="popup-file" />
<s:url value="/assets/js/jquery-ui-1-9-git.js" 
				var="jquery-ui-1-9-git.js" />
				
<s:url value="/assets/css/dialog_box.css" 
				var="dialog_box_css" />	
<s:url value="/assets/css/button.css" 
				var="button_css" />	
<s:url value="/assets/css/popup_file.css" 
				var="popup_file" />		
				
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script> 				
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<link rel="stylesheet" type="text/css" href="${dialog_box_css}" />
<link rel="stylesheet" type="text/css" href="${button_css}" />
<link rel="stylesheet" type="text/css" href="${popup_file}" />

<script type="text/javascript" src="${dialog_box}"></script>
<script type="text/javascript" src="${popup-file}"></script>
<script type="text/javascript" src="${jquery-ui-1-9-git.js}"></script>
</head>
<body>

<security:authorize access="hasAnyRole('ROLE_COMPANY','ROLE_ADMIN','ROLE_SUPER_ADMIN')">

	<s:url value="/searchuser" var="searchActionUrl" />
	<form method="POST" action="${searchActionUrl}">
	<table style="width: 550px; height: 38px; float: right" border="0"
		bordercolor="white" cellpadding="0" cellspacing="0">
		<tr>
			<td style="color:#FFFFFF; font-weight: bold; padding-right: 10px;">Search</td>
			<td><input type="text"  id="q" name="q" style="width: 360px;
			 margin-left: 5px; 
    padding: 7px 0px 7px 3px;
    
    background: none;
   -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    font-size: 16px;
    color: #999;
    outline: none;
    font-style:italic;
			"
			 onfocus="if (this.value==this.defaultValue) this.value='';"
     value="User search"  /></td><!-- value="${q}" -->
			<td><input type="submit" value="search" style="width:100px;
			 padding: 7px 0px 7px 3px;
    
    background: #0066FF;
   -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    font-size: 14px;
    color:white;
			" /></td>
		</tr>
	</table>
	</form>

</security:authorize>

<br><br><br><br>
<table width="500" border="0" >
	<tr style="font-weight: bold; background-color: #0066FF; color: white;">
		<td width="50">Sr.No.</td>
		<td width="">User Name</td>
		<td width="">First Name</td>
		<td width="">Last Name</td>
		<td width="175">Roles</td>
		<td width="175">Coupon</td>
		<!-- <td width="75">Enabled</td>-->
	</tr>
	<c:forEach items="${users}" var="item" varStatus="status">
		<c:choose>
			<c:when test="${status.count mod 2 eq 0}">
				<c:set var="rowcolor" value="even" />
			</c:when>
			<c:otherwise>
			<c:set var="rowcolor" value="odd"/>
			</c:otherwise>
		</c:choose>
		<tr class="${rowcolor}">
			<td>${status.count}</td>
			<td>
			
			<form name='fold_as_link' method="post" action="${searchActionUrl}" >
				   <input type="hidden" value="${item.username}" name="q" /> 
				  
				<button id="button">${item.username}</button> 
				
				</form>			
			
			</td>
			<td>${item.firstname}</td>
			<td>${item.lastname}</td>
			<td><c:forEach items="${item.userRoles}" var="role">
				${role.authority}<br/>
			</c:forEach></td>
			<td>
			<form method="POST" id="show" action="couponsend">
				<input type="hidden" name="userId" value="${item.userId}"/>
			</form>
			<button type="submit" form="show" class="btn btn-link">Send coupon</button>
			</td>
			<!-- <td><c:choose>
				<c:when test="${item.enabled eq 1}">
					YES
				</c:when>
				<c:otherwise>
					NO
				</c:otherwise>
			</c:choose></td> -->
		</tr>
	</c:forEach>
</table>



</body>
</html>