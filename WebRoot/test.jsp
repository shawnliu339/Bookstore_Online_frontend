<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="mybookapp1.DTO.Book"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>

<body>
	<%
		LinkedHashSet<String> books = new LinkedHashSet<String>();
		books.add("a");
		books.add("b");
		books.add("a");
		books.add("a");
		books.add("a");
		books.add("a");
		books.add("c");
		for(String temp : books) {
			out.println(temp);
		}
	%>
</body>
</html>
