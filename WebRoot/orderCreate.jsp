<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>网上图书超市</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="CSS/style.css" rel="stylesheet">
</head>
  <script type="text/javascript" src="JS/check.jsp"></script>
<body>
  <c:if test="${empty sessionScope.user }">
  	<c:redirect url="userNull.jsp"/>
  </c:if>
  <c:if test="${empty sessionScope.cartList }">
  	<c:redirect url="cartNull.jsp"/>
  </c:if>
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
                                <table width="100%" height="59"  border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td width="86%" height="61" class="tableBorder_B">
                                      <img src="Images/checkout.GIF" width="176" height="61"></td>
                                  </tr>
                                </table>
                                <form method="post" action="orderCreate.action" name="orderForm">
                                  <table width="100%" height="339"  border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                      <td width="7%" height="26">&nbsp;</td>
                                      <td height="26" colspan="2" class="word_deepgrey">注意：请您不要恶意或非法提交订单以免造成不必要的麻烦！</td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">用 户 名：</td>
                                      <td width="74%">
                                        <input name="username" type="text" id="username" value="${sessionScope.user.username }" readonly="yes">
                          *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">真实姓名：</td>
                                      <td>
                                        <input name="truename" type="text" id="truename" value="${sessionScope.user.truename }">
                          *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">联系地址：</td>
                                      <td>
                                        <input name="address" type="text" id="address" value="${sessionScope.user.address }">
                          *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">邮政编码：</td>
                                      <td>
                                        <input name="postcode" type="text" id="postcode" value="${sessionScope.user.ZIP }">
                          *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">联系电话：</td>
                                      <td>
                                        <input name="tel" type="text" id="tel" value="${sessionScope.user.tel }">
                          *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">付款方式：</td>
                                      <td>
                                        <select name="payType" class="textarea">
                                          <option>银行付款</option>
                                          <option>邮政付款</option>
                                          <option>现金支付</option>
                                        </select>
                                        *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">运送方式：</td>
                                      <td>
                                        <select name="delivery" class="textarea">
                                          <option>普通邮寄</option>
                                          <option>特快专递</option>
                                          <option>EMS专递方式</option>
                                        </select>
                                        *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="26" colspan="2" align="center">Email地址：</td>
                                      <td>
                                        <input name="email" type="text" id="email" value="${sessionScope.user.email }" size="50" readonly="readonly">
                          *
                                      </td>
                                    </tr>
                                    <tr>
                                      <td height="101" colspan="2" align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
                                      <td>
                                        <textarea name="memo" cols="50" rows="5" class="textarea" id="memo"></textarea>
                                      </td>
                                    </tr>
                                    <tr align="center">
                                      <td colspan="3">
                                        <input name="Button" type="button" class="btn_grey" value="提交" onClick="checkOrder(orderForm)">
                                        &nbsp;
                                        <input name="Submit2" type="button" class="btn_grey" value="返回" onClick="history.back(1);"></td>
                                    </tr>
                                  </table>
                                </form>
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