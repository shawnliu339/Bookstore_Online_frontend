<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

  <title>留言簿查询</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
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
                    <jsp:include page="guestbookS.jsp"/>
                  </td>
                  <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
                  <td width="73%" valign="top">
                    <table width="100%" height="272"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="97%" height="220" valign="top">
                          <table width="100%" height="109"  border="0" cellpadding="0" cellspacing="0">

                            <tr>
                              <td height="92" valign="top">
                                <table width="100%" height="87"  border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                    <td width="86%" height="87" class="tableBorder_B">
                                      <img src="Images/ico_guestbook.gif" width="176" height="61"></td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td valign="top">&nbsp;</td>
                            </tr>
                          </table>
                          <table width="100%" height="250"  border="0" cellpadding="0" cellspacing="0" class="tableBorder_B1">
                            <tr>
                              <td width="6%" valign="top" align="left">留言日期：&nbsp;</td><td valign="top" align="left">${requestScope.guestbook.date }</td>
                            </tr>
                            <tr>
                              <td valign="top" align="left"> 主&nbsp;&nbsp;&nbsp;&nbsp;题：&nbsp;</td>
                              <td valign="top" align="left">${requestScope.guestbook.title }</td>
                            </tr>
                            <tr>
                              <td valign="top" align="left">留言内容：&nbsp;</td><td valign="top" align="left">${requestScope.guestbook.content }</td>
                            </tr>
                            <tr>
                              <td valign="top" align="left">回复内容：&nbsp;</td><td valign="top" align="left">${requestScope.guestbook.reply }</td>
                            </tr>
                          </table>
                        </td>
                        <td width="3%" valign="top">&nbsp;</td>
                      </tr>
                    </table>
                    <table width="100%" height="40"  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td align="center">
                          <input name="button1" type="button" class="btn_grey" value="删除" onClick="window.location.href='guestbookDelete.action?guestbookId=${requestScope.guestbook.id }'">
                          <input name="Button" type="button" class="btn_grey" value="返回" onClick="window.location.href=document.referrer;"></td>
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