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
<title>ArticleList</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_COMPANY')">
<form method="POST" id="create" action="articlecreate">
<input type="hidden" name="documentid" value="${documentId}"/>
</form>
<button type="submit" form="create" class="btn btn-link">Create New Article</button>
</security:authorize>
<br> <br>

<c:forEach items="${article}" var="art"  >
by @ ${art.owner} <br>
subject: ${art.articleSubject} <br>

<c:set var="string1" value="${art.articleText}"/>
<c:set var="string2" value="${fn:substring(string1, 0, 300)}" /> <br>
${string2}...<br>


<form method="POST" id="articlefullpage" action="articlefullpage">
<input type="hidden" name="articleId" value="${art.articleId}"/>
</form>
<button type="submit" form="articlefullpage"  class="btn btn-link">Read More</button>

<br><br>
</c:forEach>

<br><br><br><br>





</body>
</html>