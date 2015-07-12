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
<title>Subscribe</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>


Subscripe <b>${document.metadataName}</b> with:<br><br>

1) Send with courier (${document.metadata_out_price} $) <br> <br>
<form method="GET" id="courier" action="subcourier">

</form>
<button type="submit" form="courier" class="btn btn-success">Buy</button><br><br>
2) if you have coupon code type it here: (- 50% =  ${couponPrice} $) 
<form method="POST" id="show" action="subscriberesult">
<input type="number" name="coupon" required/>
<input type="hidden" name="userId" value="${userId}"/>
<input type="hidden" name="metadataId" value="${document.metadataId}"/>
<input type="hidden" name="categoryId" value="${document.categoryId}"/>
</form>
<button type="submit" form="show" class="btn btn-success">Subscribe</button>
  <br><br>

3) Subscribe with 
<c:choose>
<c:when test="${ekptwsi == true}">
<strike>${document.metadata_web_price}</strike> <br> ${price}
</c:when>
<c:otherwise>
${document.metadata_web_price}
</c:otherwise>
</c:choose>
$

<form method="POST" id="subscr" action="subresult">
<input type="hidden" name="userId" value="${userId}"/>
<input type="hidden" name="metadataId" value="${document.metadataId}"/>
</form>
<button type="submit" form="subscr" class="btn btn-success">Subscribe</button>



</body>
</html>