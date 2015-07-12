<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<style>
p2.normal {font-style:normal;}
/*
p2.italic {font-style:italic;}
*/
p2.oblique {font-style:oblique;}
p2 {font-size:150%;}
p1 {font-size:120%;}
dms-string{font-size:200%;}
</style>
</head>
<body>

<security:authentication property="principal.username" var="uName"/>

<s:url value="/assets/images/pencils.jpg" 
				var="pencils" />

<table border="0" style="width: 100%; color: #0066FF; height:90px;">
	<tr>
		<td>
		<s:url value="/assets/images/dms_image.jpg" 
				var="dmslogo" />
			
			<s:url value="/docs" var="docsLink"/>	
			<img src="${dmslogo}" 
				alt="DOCUMENT MANAGEMENT SYSTEM" 
				width="170"
				height="90" />
				
		</td>
		
		<td>&nbsp;</td>

		<td width="150">
		
		
		 		
		<security:authorize access="isAuthenticated()">
			<table style="width: 100%; color: #0066FF;" border="0">
				<tr>
					<td><s:url value="/j_spring_security_logout" var="logoutUrl" />
					<a href="${logoutUrl}" style="color: #0066FF; margin-left:70%;">Logout</a></td>
				</tr>
				
			</table>
		
	
		
	<div id="uname">Welcome, ${uName} </div>
		<div id="pencil">	
		<img src="${pencils}" 
		width="570"
				height="90"
				 />
				 </div> 
		</security:authorize>
		</td>
	</tr>
</table>
<div id="dms_header">JOURNAL MANAGEMENT SYSTEM</div>	
</body>
</html>