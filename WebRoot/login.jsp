<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script language="javascript">
  function checkU(myform) {
    if (myform.username.value == "") {
      alert("请输入用户名!");
      myform.username.focus();
      return;
    }
    if (myform.password.value == "") {
      alert("请输入密码!");
      myform.password.focus();
      return;
    }
    myform.submit();
  }
</script>

<c:choose>
  <c:when test="${empty sessionScope.user }">
    <form name="loginform" method="post" action="login.action">
      <table width="100%" height="99" border="0" cellpadding="0"
    cellspacing="0">
        <tr>
          <td width="8%">&nbsp;</td>
          <td width="92%" height="112" valign="top"
        background="Images/index_09.gif">
            <table width="100%" border="0"
          cellpadding="0" cellspacing="0">
              <tr>
                <td width="8%" height="20">&nbsp;</td>
                <td width="81%">&nbsp;</td>
                <td width="11%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td height="24" align="center">
                  用户名
                  <input name="Username"
              type="text" class="txt_grey" id="username" size="16"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td height="24" align="center">
                  密&nbsp;&nbsp;码
                  <input
              name="Password" type="password" class="txt_grey" id="password"
              size="16" onKeydown="if(event.keyCode==13) loginform.submit();"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td height="31" align="center">
                  <input name="Button"
              type="button" class="btn_grey" value="注册"
              onClick="window.location.href='register.jsp'">
                  &nbsp;
                  <input
              name="Submit2" type="button" class="btn_grey" value="登录"
              onClick="checkU(loginform)">

                  <!-- onClick="checkU(form1)" -->

                  <input name="Submit3" type="reset" class="btn_grey" value="重置"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </form>
  </c:when>
  <c:otherwise>
    <form name="loginoutform" method="post" action="logout.action">
      <table width="100%" height="99" border="0" cellpadding="0"
    cellspacing="0">
        <tr>
          <td width="8%">&nbsp;</td>
          <td width="92%" height="112" valign="top"
        background="Images/index_09.gif">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8%" height="20">&nbsp;</td>
                <td width="81%">&nbsp;</td>
                <td width="11%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td height="24" align="center">[ ${sessionScope.user.nickname } ]您好！</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td height="24" align="center">用户ID ：${sessionScope.user.id }</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td height="31" align="center">
                  &nbsp;
                  <input type="button" name="Submit" value="修改资料" class="btn_grey" onClick="window.location.href='usermodify.jsp'">
                  <input type="submit" name="Submit22" class="btn_grey" value="退出"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td align="center">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </form>
  </c:otherwise>
</c:choose>