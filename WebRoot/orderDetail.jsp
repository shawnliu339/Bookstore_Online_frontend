<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>订单查询</title>
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
		</td>
          <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
          <td width="73%" valign="top"><table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="97%" height="220" valign="top">
			   <table width="100%" height="109"  border="0" cellpadding="0" cellspacing="0">

			    <tr>
                  <td height="92" valign="top"><table width="100%" height="87"  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="86%" height="87" class="tableBorder_B"><img src="Images/ico_order.gif" width="176" height="61"></td>
                    </tr>
                  </table>                    </td>
			     </tr>
			    <tr>
			      <td valign="top">&nbsp;</td>
			    </tr>
              </table>
					  <table width="100%" height="250"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B1">
                        <tr>
                          <td width="16%">订 单 号：&nbsp;${requestScope.order.id }</td>
                          </tr>
                        <tr>
                          <td>真实姓名：&nbsp;${requestScope.order.truename }</td>
                        </tr>
                        <tr>
                          <td>地&nbsp;&nbsp;&nbsp;&nbsp;址：&nbsp;${requestScope.order.address }</td>
                        </tr>
                        <tr>
                          <td>邮政编码：&nbsp;${requestScope.order.ZIP }</td>
                          </tr>
                        <tr>
                          <td>电&nbsp;&nbsp;&nbsp;&nbsp;话：&nbsp;${requestScope.order.tel }</td>
                          </tr>
                        <tr>
                          <td>Email&nbsp;&nbsp;&nbsp;：&nbsp;${requestScope.order.email }</td>
                          </tr>
                        <tr>
                          <td>付款方式：&nbsp;${requestScope.order.payType }</td>
                        </tr>
                        <tr>
                          <td>运送方式：&nbsp;${requestScope.order.delivery }</td>
                        </tr>
                        <tr>
                          <td>订单日期：&nbsp;${requestScope.order.date }</td>
                        </tr>
                        <tr>
                          <td>订单状态：
                            <c:choose>
                              <c:when test="${requestScope.order.state == 1 }">等待买家付款</c:when>
                              <c:when test="${requestScope.order.state == 2 }">等待卖家发货</c:when>
                              <c:when test="${requestScope.order.state == 3 }">等待确认收货</c:when>
                              <c:when test="${requestScope.order.state == 4 }">等待确认付款</c:when>
                              <c:when test="${requestScope.order.state == 5 }">交易完成</c:when>
                              <c:otherwise>交易取消</c:otherwise>
                            </c:choose>
                          </td>
                        </tr>
                        <tr>
                          <td>备&nbsp;&nbsp;&nbsp;&nbsp;注：&nbsp;${requestScope.order.memo }</td>
                        </tr>
                      </table>
					  <table width="100%"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B1">
                        <tr align="center" bgcolor="#eeeeee">
                          <td width="16%" height="27">图书ISBN号</td>
                          <td width="48%">图书名称</td>
                          <td width="20%">出版社</td>
                          <td width="9%">单价</td>
                          <td width="7%">数量</td>
                          </tr>
						<c:forEach items="${requestScope.bookOmitList }" var="bookOmit">
                        <tr align="center">
                          <td height="27">${pageScope.bookOmit.ISBN }</td>
                          <td height="27">${pageScope.bookOmit.name }</td>
                          <td height="27">${pageScope.bookOmit.publisher }</td>
                          <td>${pageScope.bookOmit.price }(元)</td>
                          <td>${pageScope.bookOmit.amount }</td>
                          </tr>
						</c:forEach>
                      </table></td>
              <td width="3%" valign="top">&nbsp;</td>
            </tr>
          </table>
            <table width="100%" height="40"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><input name="Button" type="button" class="btn_grey" value="返回" onClick="history.back();"></td>
              </tr>
            </table></td>
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