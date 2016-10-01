<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>网上图书超市</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet">
</head>
<body>
<table width="100%"  border="0" cellspacing="0" cellpadding="0" background="Images/bg.gif">
  <tr>
    <td><table width="777" height="768"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr>
          <td valign="top"><jsp:include page="head.jsp"/>
            <table width="100%" height="330"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="26%" valign="top"><jsp:include page="login.jsp"/></td>
                <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
                <td width="73%" valign="top"><table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="52" colspan="3" background="Images/index_10.gif"><jsp:include page="search.jsp"/></td>
                    </tr>
                    <tr>
                      <td width="97%" height="220" valign="top"><table width="100%" height="126"  border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td><table width="100%" height="123"  border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td width="23%" align="center" valign="top"><img src="Images/BookCover/${requestScope.book.img }" width="110" height="158"></td>
                                  <td width="77%"><table width="100%" height="202"  border="0" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td width="16%" height="24">书&nbsp;&nbsp;号：</td>
                                        <td width="84%">${requestScope.book.ISBN }</td>
                                      </tr>
                                      <tr>
                                        <td width="16%" height="24">书&nbsp;&nbsp;名：</td>
                                        <td width="84%">${requestScope.book.name }</td>
                                      </tr>
                                      <tr>
                                        <td height="24">出版社：</td>
                                        <td>${requestScope.book.publisher }</td>
                                      </tr>
                                      <tr>
                                        <td height="24">作&nbsp;&nbsp;者：</td>
                                        <td>${requestScope.book.author }</td>
                                      </tr>
                                      <tr>
                                        <td height="24">定 &nbsp;价：</td>
                                        <td>${requestScope.book.price }（元）</td>
                                      </tr>
                                      <tr>
                                        <td height="24">出版日期：</td>
                                        <td>${requestScope.book.date }</td>
                                      </tr>
                                      <tr>
                                        <td height="39" colspan="2">${requestScope.book.introduction }</td>
                                      </tr>
                                      <tr>
                                        <td height="40" colspan="2"><c:if test="${!empty sessionScope.user }">
                                            <input name="Submit5" type="submit" class="btn_grey" value="放入购物车" onClick="window.location.href='cartAdd.action?id=${requestScope.book.id}'">
                                          </c:if>
                                          <input name="Submit52" type="button" class="btn_grey" value="返回" onClick="window.location.href=document.referrer;"></td>
                                      </tr>
                                    </table></td>
                                </tr>
                              </table></td>
                          </tr>
                        </table></td>
                      <td width="3%" valign="top">&nbsp;</td>
                    </tr>
                  </table></td>
              </tr>
            </table>
            <jsp:include page="tail.jsp"/></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
