<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网上图书超市-留言簿查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="CSS/style.css" rel="stylesheet">

  </head>
  <body>
    <table width="100%"  border="0" cellspacing="0" cellpadding="0" background="Images/bg.gif">
    <tr>
      <td>
        <table width="777" height="768"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
          <tr>
            <td valign="top">
              <jsp:include page="head.jsp"/>
              <table width="100%" height="330"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="26%" valign="top">
                    <jsp:include page="login.jsp"/>
                    <jsp:include page="guestbookS.jsp"/>
                  </td>
                  <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
                  <td width="73%" valign="top">
                    <table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="97%" height="220" valign="top">
                          <table width="100%" height="126"  border="0" cellpadding="0" cellspacing="0">

                            <tr>
                              <td valign="top">
                                <table width="100%" height="87"  border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td width="86%" height="87" class="tableBorder_B">
                                      <img src="Images/ico_guestbook.gif" width="176" height="61"></td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td valign="top">
                                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                                  <tr align="center">
                                    <td width="26%" height="30" class="tableBorder_B1">留言日期</td>
                                    <td width="13%" class="tableBorder_B1">用户名</td>
                                    <td width="15%" class="tableBorder_B1">主题</td>
                                    <td width="24%" class="tableBorder_B1">内容</td>
                                    <td width="9%" class="tableBorder_B1">是否回复</td>
                                    <td width="13%" class="tableBorder_B1">是否删除</td>
                                  </tr>
                                  <c:forEach items="${requestScope.guestbookList }" var="guestbook">
                                    <tr align="center">
                                      <td height="24">${pageScope.guestbook.date }</td>
                                      <td>${sessionScope.user.username }</td>
                                      <td id="title"><a href="guestbookDetail.action?guestbookId=${pageScope.guestbook.id }">${pageScope.guestbook.title }</a></td>
                                      <td id="contents">${pageScope.guestbook.content }</td>
                                      <td>
                                        <c:choose>
                                          <c:when test="${pageScope.guestbook.replyFlag == 0 }">否</c:when>
                                          <c:when test="${pageScope.guestbook.replyFlag == 1 }">是</c:when>
                                        </c:choose>
                                      </td>
                                      <td><a href="guestbookDelete.action?guestbookId=${pageScope.guestbook.id }">删除</a></td>
                                    </tr>
                                  </c:forEach>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                        <td width="3%" valign="top">&nbsp;</td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
              <jsp:include page="tail.jsp"/>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  </body>
</html>
