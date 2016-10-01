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
                                    <td width="86%" height="59" class="tableBorder_B">
                                      <img src="Images/ico_cart.gif" width="176" height="70"></td>
                                  </tr>
                                </table>
                                <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td>
                                      <form method="post" action="cartModify.action" name="cartGoodsForm">
                                        <table width="100%" height="48" border="0" align="center" cellpadding="0" cellspacing="0">
                                          <tr align="center" valign="middle">
                                            <td height="27" class="tableBorder_B1">编号</td>
                                            <td height="27" class="tableBorder_B1">书号</td>
                                            <td class="tableBorder_B1">书名</td>
                                            <td height="27" class="tableBorder_B1">单价</td>
                                            <td height="27" class="tableBorder_B1">数量</td>
                                            <td height="27" class="tableBorder_B1">金额</td>
                                            <td class="tableBorder_B1">退回</td>
                                          </tr>
                                         <c:forEach items="${sessionScope.cartList }" var="cart" varStatus="i">
                                         
                                         
                                          <tr align="center" valign="middle">
                                            <td width="32" height="27">
                                              ${pageScope.i.count }
                                            </td>
                                            <td width="109" height="27">
                                              ${pageScope.cart.ISBN }</td>
                                            <td width="199" height="27">
                                              ${pageScope.cart.name }</td>
                                            <td width="59" height="27">
                                              ￥
                                              ${pageScope.cart.price }</td>
                                            <td width="51" height="27">
                                              <input name="amount${pageScope.i.count }" size="7" type="text" class="txt_grey" value="${pageScope.cart.amount }" onBlur="checkCartModify${pageScope.i.count }();" onkeydown="if(event.keyCode==13){checkCartModify${pageScope.i.count }();}"></td>
                                            <td width="65" height="27">
                                              ￥
                                              ${pageScope.cart.money }</td>
                                            <td width="34">
                                              <a href="cartRemove.action?index=${pageScope.i.index }&bookId=${pageScope.cart.bookId }">
                                                <img src="Images/del.gif" width="16" height="16"></a>
                                            </td>
                                            <script language="javascript">
                                              function checkCartModify${pageScope.i.count }() {
                                            	if(isNaN(cartGoodsForm.amount${pageScope.i.count }.value)) {
                                          		  alert("请不要输入非法字符");
                                          		  cartGoodsForm.amount${pageScope.i.count }.focus();
                                           		  return false;
                                            	  history.back();
                                            	}
                                            	if(cartGoodsForm.amount${pageScope.i.count }.value=="" || cartGoodsForm.amount${pageScope.i.count }.value==0) {
                                              	  alert("请输入修改的数量");
                                              	  cartGoodsForm.amount${pageScope.i.count }.focus();
                                            	  return false;
                                            	  history.back();
                                            	} 
                                            	window.location = "cartModify.action?index=${pageScope.i.index }&amount="+cartGoodsForm.amount${pageScope.i.count }.value;
                                              }
                                            </script>
                                            </c:forEach>
                                            </tr>
                                        </table>
                                      </form>
                                      <table width="100%" height="52" border="0" align="center" cellpadding="0" cellspacing="0">
                                        <tr align="center" valign="middle">
                                          <td height="10">&nbsp;</td>
                                          <td width="24%" height="10" colspan="-3" align="left">&nbsp;</td>
                                        </tr>
                                        <tr align="center" valign="middle">
                                          <td height="21" class="tableBorder_B1">&nbsp;</td>
                                          <td height="21" colspan="-3" align="left" class="tableBorder_B1">
                                            合计总金额：￥
                                            ${sessionScope.allMoney }</td>
                                        </tr>
                                        <tr align="center" valign="middle">
                                          <td height="21" colspan="2">
                                            <a href="#" onClick="cartGoodsForm.submit();">修改数量</a>
                                            |
                                            <a href="bookSort.jsp">继续购书</a>
                                            |
                                            <a href="orderCreate.jsp">去收银台结账</a>
                                            |
                                            <a href="cartClear.action">清空购物车</a>
                                          </td>
                                        </tr>
                                      </table>
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
