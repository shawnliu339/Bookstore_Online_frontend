<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>网上书店</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		String message = (String)request.getAttribute("message");
		String target = (String)request.getAttribute("target");
		
		if(!target.equals("back")) {
	%>
	<script language='javascript'>
		alert("<%=message %>");
		window.location.href='<%=target%>';
	</script>
	<%
		} else {
	%>
	<script language='javascript'>
		alert("<%=message %>");
		window.location.href='javascript:history.go(-1);';
	</script>
	<%
		}
	%>
	<br>
</body>
</html>
