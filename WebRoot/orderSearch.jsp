<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>订单查询</title>
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
                    <jsp:include page="login.jsp"/>
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
                                      <img src="Images/ico_order.gif" width="176" height="61"></td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td valign="top">
                                <table width="100%"  border="0" cellpadding="0" cellspacing="0">
                                  <tr align="center">
                                    <td width="8%" height="30" class="tableBorder_B1">订单号</td>
                                    <td width="17%" class="tableBorder_B1">订单状态</td>
                                    <td width="10%" class="tableBorder_B1">购买书目</td>
                                    <td width="13%" class="tableBorder_B1">真实姓名</td>
                                    <td width="9%" class="tableBorder_B1">付款方式</td>
                                    <td width="17%" class="tableBorder_B1">运送方式</td>
                                    <td width="26%" class="tableBorder_B1">订书日期</td>
                                  </tr>
                                  <c:forEach items="${requestScope.orderList }" var="order">
                                    <tr align="center">
                                      <td height="24">
                                        <a href="orderDetail.action?orderId=${pageScope.order.id }">${pageScope.order.id }</a>
                                      </td>
                                      <td>
                                        <c:choose>
                                          <c:when test="${pageScope.order.state == 1 }">等待买家付款</c:when>
                                          <c:when test="${pageScope.order.state == 2 }">等待卖家发货</c:when>
                                          <c:when test="${pageScope.order.state == 3 }">等待确认收货</c:when>
                                          <c:when test="${pageScope.order.state == 4 }">等待确认付款</c:when>
                                          <c:when test="${pageScope.order.state == 5 }">交易完成</c:when>
                                          <c:otherwise>交易取消</c:otherwise>
                                        </c:choose>
                                      </td>
                                      <td>${pageScope.order.goodsAmount }</td>
                                      <td>${pageScope.order.truename }</td>
                                      <td>${pageScope.order.payType }</td>
                                      <td>${pageScope.order.delivery }</td>
                                      <td>${pageScope.order.date }</td>
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