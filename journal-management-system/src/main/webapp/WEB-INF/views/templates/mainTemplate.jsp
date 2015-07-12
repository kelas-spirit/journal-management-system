<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<title>DMS | <t:getAsString name="title" ignore="true" /></title>

<link href="<s:url value="/assets" />/css/styles.css"
	rel="stylesheet" type="text/css" />


<script type="text/javascript" src='<s:url value="/assets/js/jquery-1.8.0.js"/>'>
</script>

<script type="text/javascript" src='<s:url value="/assets/js/dms.js"/>'>
</script>

</head>

<body>
	<div id="container">
		<div id="header">
			<t:insertAttribute name="top" />
		</div>
		
		<div class="content-container">
			<div class="side">
				<t:insertAttribute name="side" />
				
			</div>
			<div class="content">
				<t:insertAttribute name="content" />
			</div>
			<div style="clear:both"></div>
		</div>
		<div class="page-footer">
			<t:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>
