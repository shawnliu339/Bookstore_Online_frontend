<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>网上图书超市</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="CSS/style.css" rel="stylesheet"></head>
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
                    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td height="40" align="center">&nbsp;</td>
                        <td height="40" align="center" background="Images/bg_booksort.gif">
                          <table width="100%" height="26"  border="0" cellpadding="0" cellspacing="0">
                            <tr>
                              <td width="29%" align="right" class="word_white">
                                <img src="Images/ico_booksort.gif" width="25" height="25"></td>
                              <td width="71%" class="word_white">&nbsp;图书分类列表</td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <tr>
                        <td width="20" height="31">&nbsp;</td>
                        <td width="182" height="31">
                          <c:forEach items="${requestScope.types }" var="type">
                            <table width="100%" height="22"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B1">
                              <tr>
                                <td width="16%" align="right">
                                  <img src="Images/boardlist.gif" width="25" height="14"></td>
                                <td width="84%" height="26">
                                  <a href="bookSort.action?type=${pageScope.type }">
                                    &nbsp;
                                  ${pageScope.type }
                                  </a>
                                </td>
                              </tr>
                            </table>
                          </c:forEach>
                        </td>
                      </tr>
                    </table>
                  </td>
                  <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
                  <td width="73%" valign="top">
                    <table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td height="52" colspan="3" background="Images/index_10.gif">
                          <jsp:include page="search.jsp"/>
                        </td>
                      </tr>
                      <tr>
                        <td width="97%" height="220" valign="top">
                          <table width="100%" height="126"  border="0" cellpadding="0" cellspacing="0">

                            <tr>
                              <td valign="top">
                                <table width="100%" height="55"  border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td class="tableBorder_B">
                                      	图书类别：[${requestScope.type }]
                                    </td>
                                  </tr>
                                  <tr>
                                    <td width="86%" height="100" valign="top">
                                      <table width="96%" height="34"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder_B">
                                        <tr>
                                          <td width="6%" height="33" align="center">&nbsp;</td>
                                          <td width="40%" style="padding:5px;">书名</td>
                                          <td width="26%" style="padding:5px;">出版社</td>
                                          <td width="14%" style="padding:5px;">单价</td>
                                          <td width="14%" style="padding:5px;">购买</td>
                                        </tr>
                                      </table>
                                      <c:forEach items="${requestScope.books }" var="book">
                                        <table width="96%" height="21"  border="0" align="center" cellpadding="0" cellspacing="0" class="tableBorder_B">
                                          <tr>
                                            <td width="6%" align="center">
                                              <img src="Images/greendot.gif" width="11" height="13"></td>
                                            <td width="40%" style="padding:5px;">
                                              <a href="bookdetail.action?id=${pageScope.book.id }">${pageScope.book.name }</a>
                                            </td>
                                            <td width="26%" style="padding:5px;">${pageScope.book.publisher }</td>
                                            <td width="14%" style="padding:5px;">${pageScope.book.price }</td>
                                            <td width="14%" style="padding:5px;">
                                              <c:choose>
                                                <c:when test="${!empty sessionScope.user }">
                                                  <input name="Submit5" type="submit" class="btn_grey" value="购买" onClick="window.location.href='cartAdd.action?id=${pageScope.book.id }'"></c:when>
                                                <c:otherwise>请先登录</c:otherwise>
                                              </c:choose>
                                            </td>
                                          </tr>
                                        </table>
                                      </c:forEach>
                                    </td>
                                  </tr>
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