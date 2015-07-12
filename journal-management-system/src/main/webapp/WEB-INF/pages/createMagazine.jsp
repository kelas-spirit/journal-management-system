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

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script> 
<script src="//github.com/fyneworks/multifile/blob/master/jQuery.MultiFile.min.js" type="text/javascript" language="javascript"></script>
<script>

</script>

<title>Create</title>
</head>
<body>



<br><br>
<form method="POST" id="submit" action="upload" enctype="multipart/form-data">
Upload cover photo: <input type="file" name="document" class="multi" accept="image/*"/><br /><br>

Name: <input type="text" name="name" required><br /> <br />

Price: <input type="number" step="any" name="out_price" required><br /> <br />

Price(Web): <input type="number" step="any" name="web_price" required><br /> <br />

Range edition: 
<select id="selectedRange" name="selectedRange">

				<c:forEach var="range" items="${rangelist}">

                <option value="${range.metadata_range_id}">${range.metadata_range_name}</option>

            </c:forEach>

</select>
<br><br>
Category:
<select id="selectedCategory" name="selectedCategory">

				<c:forEach var="category" items="${categorylist}">

                <option value="${category.category_id}">${category.category_name}</option>

            </c:forEach>

</select>

</form>


<button type="submit" form="submit" value="Submit">Submit</button>

</body>
</html>