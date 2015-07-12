<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

by @ ${art.owner} <br>
subject: ${art.articleSubject} <br><br><br><br>
${art.articleText}<br><br>

<br><br>
<b>Comments:</b> <br> <br>
<c:forEach items="${com}" var="comment"  >

${comment.username} says: ${comment.comment_text} <br>


</c:forEach>

<form method="POST" id="comment" action="commentcreate">
New comment:<br> <textarea name="text" rows="15" cols="90" required></textarea>
<input type="hidden" name="articleId" value="${art.articleId}"/>
</form>
<button type="submit" form="comment" class="btn btn-warning" value="Submit">Send Comment</button>




</body>
</html>