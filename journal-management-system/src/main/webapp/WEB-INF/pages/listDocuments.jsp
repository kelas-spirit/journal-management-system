<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  -->
  
<!DOCTYPE html> 
<%@page import="javax.servlet.jsp.jstl.core.LoopTagSupport"%>

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
<style>
#errorMessage {
color:red;
font-style:italic; 
}



</style>

<script>
var count = 1;
function generatenew(){
	var element =  document.getElementById("txtBox");
	var regexp = /^[A-Za-z0-9_-]{3,20}$/;
	if (count > 1) {
        
       showDialog('Error','Error! Please,type folder name. ','error');            
	}
	 count++;//problem with count if it in the end of code,pizdets koro4e...
	 document.abc.image.style.visibility="visible"; 
    document.abc.food.style.visibility="visible";
    document.abc.submit.style.visibility="visible";
    
   
}

function Empty(element){
	var regexp = /^[A-Za-z0-9_-]{1,20}$/;  // 1,20 is it range value 

    if(element.value.trim()== ""){

      document.getElementById("errorMessage").innerHTML="Folder name is empty. Try again.";
        element.focus();
        
        return false;
    }  
    if(!element.value.match(regexp))
    {

    	document.getElementById("errorMessage").innerHTML="Unavailable characters. Try again.";

    return false;
    }

    return true;   
}

function reloadPage()
{
location.reload();
}

</script>

</head>

<body>
<security:authentication property="principal.username" var="uName"/>
 <!-- thetoume metavlites -->
 <c:set var="wpleader" value="false" />
 <c:set var="taskleader" value="false" />
 
 
<c:if test="${not empty pr}">

	<c:forEach items="${pr}" var="pr" varStatus=" ">
		<c:if test="${uName eq pr.username}">
 <c:set var="taskleader" value="true" />

		</c:if>

</c:forEach>
</c:if>

<c:if test="${not empty prw}">

	<c:forEach items="${prw}" var="prw" varStatus=" ">
		<c:if test="${uName eq prw.username}">
 <c:set var="wpleader" value="true" />

		</c:if>

</c:forEach>
</c:if>

<br />

<!-- Here we have text box for search and we deleted toptabs -->
<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')">

	<s:url value="/search" var="searchActionUrl" />
	<form method="GET" action="${searchActionUrl}">
	<table style="width: 550px; height: 38px; float: right" border="0"
		bordercolor="white" cellpadding="0" cellspacing="0">
		<tr>
			<td style="color:#FFFFFF; font-weight: bold; padding-right: 10px;">Search</td>
			<td><input type="text"  id="q" name="q" style="width: 420px;
			 margin-left: 5px; 
    padding: 7px 0px 7px 3px;
    
    background: none;
   -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    font-size: 14px;
    color: #999;
    outline: none;
    font-style:italic;
			"
			 onfocus="if (this.value==this.defaultValue) this.value='';"
     value="Document search"  /></td><!-- value="${q}" -->
			<td><input type="submit" value="search" style="width:100px;
			 padding: 7px 0px 7px 3px;
    
    background: #0066FF;
    color:white;
   -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    font-size: 14px;
			" /></td>
		</tr>
	</table>
	</form>

</security:authorize>

<!-- end of textbox for search -->







<!-- Create folders -->



 




<!-- The following characters are not allowed: \ / : ? * < > " | -->

<c:choose>
<c:when test="${uName eq owner}">
  <input type="button" title="Create new folder" value=" " onclick="generatenew();" style ="background-image: url(${add_folder});
  background-repeat:no-repeat;width:25px; height:25px;outline: 0;
  background-color:white;padding:0; border:none;">
  &nbsp;
  <a href="/dms/upload">
<input type="button" title="Create new file"  value=" "  style ="background-image: url(${add_file});
  background-repeat:no-repeat;width:25px; height:25px;outline: 0;
  background-color:white;padding:0; border:none;">
</a>
</c:when>
</c:choose>
<div id="errors">
${errorMsg}
</div>

<div id="content">
 <form name='abc' method="post" action="/dms/create_folder" id="submit" > 
  
  
  


     <br>  <br>   

 
 
 
 <img src="${folder}" 
				width="30"
				height="32"
				name="image"
				style=" visibility:hidden;float: left;"
				 /> 
   
 
 <input type="text" id="txtBox" style="
   visibility:hidden;
     width: 280px;
   height: 30px;
  margin-left: 5px; 
    padding: 10px 0px 10px 3px;
    float: left;
    background: none;
   -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    font-size: 14px;
    color: #999;
    outline: none;
    font-style:italic; "  
      onfocus="if (this.value==this.defaultValue) this.value='';"
     value="Type folder name"  name="food"  >
&nbsp;
<!--   -->
<!-- sumbit button for folder -->
<input type="submit"  value="Create" onclick="return Empty(document.getElementById('txtBox'));"
style="visibility:hidden; background-color:#3366FF ;
background-repeat:no-repeat; width:50px; height:27px;outline: 0;
  padding:0; border:none;color:white;" name="submit" > 
 <!-- reloadPage(); -->

</form>

 <!-- here simple error code(simple string) -->
   <div id="errorMessage">
 </div>


</div>

<!-- end of creates folders -->







<table style="width: 100%; " border="0" id="folderTable">
	<tr style="color:#3366FF;text-decoration:underline;">
		<td width="25"></td>
		<td>Document</td>
		<td>Id</td>
		<td>Details</td>
		<td width="120">Comments</td>
		<td width="120">Owner</td>
	<!-- 	<td width="120">Uploaded by</td>  -->
		<td width="100">Created Date</td>
		<td width="100">Updated Date</td>
	<!-- 	<td width="100">Size</td>  -->
		<td width="20"></td>

<c:forEach items="${fold}" var="fold" varStatus=" " >
    <tr style="height: 35px; ">
    <td width="25">
    
    <c:set var="currency" value="USD"  />
    
    <div
				style="background-color: #F2F2F2; width: 25px; height: 25px; float: left; margin-right: 10px;"><img
				src="${folder}"width="25"
				height="25" /></div>
    </td>
    
    <!--   <td><a id="${fold.folderId}" href="<s:url value="/docs/${fold.folderName}"/>">${fold.folderName}</a> </td> -->
  
  
  
  <td>
  
  <form name='fold_as_link' method="post" action="/dms/fold/${fold.folderName}" > <!-- /dms/docs/${fold.folderName} -->
  	  
  		<input type="hidden" value="${fold.folderName}" name="folderName" />
  		<input type="hidden" value="${fold.folderId}" name="folderId" /> 
  		<input type="hidden" value="${fold.folderPath}" name="folderPath" />
  		<input type="hidden" value="${fold.parrentId}" name="parrentId" />
  		<input type="hidden" value="${fold.pathId}" name="pathId" />
  		
  		<!--  <input type="submit" value="${fold.folderName}"/> -->
  		
  		<button id="button">${fold.folderName}</button> 		 
  </form>
 </td> 
    
    
		<td style="color:green;">
		<c:if test ="${wpleader==true or taskleader==true}">
		N/A
		</c:if>
		<c:if test ="${wpleader==false and taskleader==false}">
		
		${fold.folderId}
		
		</c:if>
		</td>
		
		<!-- details -->
	<td width="120">
	
	</td>	
    <td width="120"></td>
    <td width="120">${fold.createUser}</td>
    
    <td width="100"><fmt:formatDate value="${fold.createdDate}" /></td>
    <td></td>
    <td>
    <c:choose>
				<c:when test="${uName eq fold.createUser or userIsAdmin}">
					<a href="javascript:deleteDocument('<s:url value="/fold/delete"/>?id=${fold.folderId}');">
					<img title="Click to delete file" src="<s:url value="/assets/images/file-delete-1.png"/>"
						style="width: 24px; height: 24px;" /></a>
				</c:when>
				<c:otherwise>
					<img  src="<s:url value="/assets/images/delete-icon-grey.png"/>"
						style="width: 24px; height: 24px;" alt="No Permissions" title="No Permissions"/>
				</c:otherwise>
			</c:choose>
    </td>
    </tr>
    
    </c:forEach>
    
    
    
    <!-- 
    Public Folder:
     -->
     
          
     <tr style="height: 40px;">
       <td width="25">
    
    <c:set var="currency" value="USD"  />
    
    <div
				style="background-color: #F2F2F2; width: 25px; height: 25px; float: left; margin-right: 10px;"><img
				src="${public_folder}"width="25"
				height="25" /></div>
    </td>
     <td>
     <a href="/dms/public_folder">Public Folder</a>
     
     </td>
     </tr>
     
   
    
	<c:forEach items="${lst}" var="item" varStatus="status">

		<c:choose>
			<c:when
				test="${item.documentType eq 'application/msword' 
			or item.documentType eq 'application/vnd.ms-word.document.12'}">
				<s:url value="/assets/images/word-icon.png" var="icon" />
			</c:when>
			<c:when test="${item.documentType eq 'application/pdf'}">
				<s:url value="/assets/images/pdf-icon.png" var="icon" />
			</c:when>
			<c:when test="${item.documentType eq 'text/plain'}">
				<s:url value="/assets/images/text-icon.png" var="icon" />
			</c:when>
			<c:when
				test="${item.documentType eq 'application/vnd.ms-excel'
			or item.documentType eq 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'}">
				<s:url value="/assets/images/excel-icon.png" var="icon" />
			</c:when>
			<c:when test="${item.documentType eq 'text/html'}">
				<s:url value="/assets/images/ie-icon.png" var="icon" />
			</c:when>
			<c:when
				test="${item.documentType eq 'application/zip' 
			or item.documentType eq 'application/java-archive'}">
				<s:url value="/assets/images/zip-icon.png" var="icon" />
			</c:when>
			<c:when test="${item.documentType eq 'application/octet-stream'}">
				<s:url value="/assets/images/rar-icon.png" var="icon" />
			</c:when>
			<c:when
				test="${item.documentType eq 'image/jpeg'
			or item.documentType eq 'image/gif'
			or item.documentType eq 'image/png'}">
				<s:url value="/assets/images/img-icon.png" var="icon" />
			</c:when>
			 <c:otherwise> 
			 <s:url value="/assets/images/file_30x30.png" var="icon" />
			 </c:otherwise>
			
		</c:choose>
<!-- 
		<c:choose>
			<c:when test="${(status.count mod 2 ) eq 0}">
				<c:set var="className" value="even" scope="page" />
			</c:when>
			<c:when test="${(status.count mod 2 ) ne 0}">
				<c:set var="className" value="odd" scope="page" />
			</c:when>

		</c:choose>  -->
		<tr>
			<td width="25">
			<div
				style="width: 25px; height: 25px; float: left; margin-right: 10px;"><img
				src="${icon}" /></div>
			</td>
			<td title="Click link to download Document"><a
				id="${item.metadataId}"
				href="<s:url value="/download/${item.metadataId}"/>">${item.documentFileName}</a></td>
			
			<td>
			
	<c:if test ="${taskleader==true}">
	<c:if test="${item.documentType  eq 'text/x-csrc'
	 or item.documentType eq 'text/x-java'
	 or item.documentType eq 'application/javascript'
	 or item.documentType eq 'text/plain'
	 or item.documentType eq 'application/octet-stream'}">
	<form name='role_as_link' method="post" action="/dms/blob/editfile" > 
	  	  <input type="hidden" value="${item.metadataId}" name="documentId" />
	
	
		  		<button id="button">View/Edit</button> 		 
		
	</form>
	
	
	
	</c:if>
	</c:if>
	<c:if test ="${wpleader==true and taskleader==false}">
	
	<c:if test="${item.documentType  eq 'text/x-csrc'
	 or item.documentType eq 'text/x-java'
	 or item.documentType eq 'application/javascript'
	 or item.documentType eq 'text/plain'
	 or item.documentType eq 'application/octet-stream'}">
	<form name='role_as_link' method="post" action="/dms/blob/view" > 
  	  <input type="hidden" value="${item.metadataId}" name="documentId" />
  	  
  		
  		
  		<button id="button">View</button> 		 
  </form>
	</c:if>
	
	</c:if>
	
	<c:if test ="${wpleader==false and taskleader==false}">
	N/A
	</c:if>
			
			</td>
			<td width="120"></td>
			<td width="120">${item.comments}</td>
			<td width="120">${item.owner}</td>
		<!-- 	<td width="120">${item.createUser}</td>  -->
			<td width="100">
			<c:if test="${empty item.createdDate }">
			
			 <s:url value="/previsousversion" var="previsousversion" />
			 <form method="post" action="${previsousversion}" >
			 <input type="hidden" value="${item.parrentId}" name="parrentId" />
			 <input type="hidden" value="${item.documentFileName}" name="documentFileName" />
			
			<button id="button">Previous Version</button> 			
			</form>
			 </c:if>
			<c:if test="${!empty item.createdDate }">
			<fmt:formatDate value="${item.createdDate}" />
			</c:if>
			</td>
			<!--  <td width="100"><c:if test="${item.updatedDate eq null}">
					Not Updated
				</c:if></td>-->
				<td width="100" style="color:green;">
					<fmt:formatDate value="${item.updatedDate }" />
				</td>
			<!-- <td width="100" >${item.documentSize}&nbsp;Bytes</td>  -->
			<td width="20">
			
			<%-- 
			User should be able to see the delete link only if he is an admin or owner 
			of the document. This will be helpful in case of public docs where 
			user will not be able to delete public docs that he does not own.
			--%>
			
			
			<c:choose>
				<c:when test="${uName eq item.owner or userIsAdmin}">
					<a href="javascript:deleteDocument('
					
					<c:url value="/docs/deleteall">
  					 <c:param name="parrentId" value="${item.parrentId}"/>
  					 <c:param name="documentFileName" value="${item.documentFileName}"/>
					</c:url>
					
					');">
					<img title="Click to delete file" src="<s:url value="/assets/images/file-delete-1.png"/>"
						style="width: 24px; height: 24px;" /></a>
				</c:when>
				<c:otherwise>
					<img  src="<s:url value="/assets/images/delete-icon-grey.png"/>"
						style="width: 24px; height: 24px;" alt="No Permissions" title="No Permissions"/>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</c:forEach>
</table>




</body>
</html>