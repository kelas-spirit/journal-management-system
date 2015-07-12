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
<title>Subscribed</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>




<table style="width: 50%; " border="0" id="folderTable">
<tr style="color:#3366FF;text-decoration:underline;">

<c:forEach items="${doc}" var="document"  >
<tr>
<td>
<img  src="data:image/jpeg;base64,${document.metadata_cover_photo}" 
            width="170"
				height="90"/>
				</td>
				<td>
Category: ${document.categoryName} <br>
Name: ${document.metadataName}<br>
Price: ${document.metadata_out_price} $ <br>
Price (web): ${document.metadata_web_price} $<br>

<form method="POST" id="show" action="articlelist">
<input type="hidden" name="documentid" value="${document.metadataId}"/>
</form>
<button type="submit" form="show" class="btn btn-success">Show</button>
<a href="javascript:unscribe('<s:url value="/deletedsubscription"/>?id=${document.metadataId}&&usId=${userId}');">
					<img title="Click to unscribe" src="<s:url value="/assets/images/file-delete-1.png"/>"
						style="width: 24px; height: 24px;" /></a> 
</td>

</tr>
</c:forEach>
</tr>
</table>




</body>
</html>