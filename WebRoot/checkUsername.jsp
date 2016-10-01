<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>检测用户名</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet">
</head>

<body bgcolor="white">
    <table width="90%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="7" align="center">&nbsp;</td>
        </tr>	  
	  <c:if test="${!empty requestScope.judge }">
	  	<tr>
          <td height="56" align="center">祝贺您!<br><br>[${requestScope.username }]用户名没有被注册!</td>
        </tr>
	  </c:if>
	  
	  <c:if test="${empty requestScope.judge }">
	  	<tr>
          <td height="45" align="center">很报歉!<br><br>${requestScope.username }用户名已经被注册!</td>
        </tr>
	  </c:if>
    </table>
</body>
</html>
