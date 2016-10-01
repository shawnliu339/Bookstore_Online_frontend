<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>网上图书超市</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/style.css" rel="stylesheet">
<script src="JS/check.jsp"></script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
		background="Images/bg.gif">
  <tr>
    <td><table width="777" height="768" border="0" align="center"
					cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr>
          <td valign="top"><jsp:include page="head.jsp" />
            <table width="100%" border="0" cellspacing="0" cellpadding="0"
								class="tableBorder_LTR">
              <tr>
                <td height="30" align="center" bgcolor="#eeeeee">≡≡≡ 用户注册信息 ≡≡≡</td>
              </tr>
            </table>
            <table width="100%" height="330" border="0" cellpadding="0"
								cellspacing="0" class="tableBorder_LBR">
              <tr>
                <td width="26%" valign="top"><table width="100%"
											border="0" cellspacing="-2" cellpadding="-2">
                    <tr>
                      <td width="55%" height="82" align="center" class="word_grey">&nbsp;<img
													src="Images/reg.gif" width="84" height="54"></td>
                      <td width="45%" align="left" class="word_grey"><b>注册帮助</b></td>
                    </tr>
                    <tr>
                      <td height="112" colspan="2" valign="top" class="word_grey"><ul>
                          <li> 用户名：为用户进行订单查询的通行证号，可使用英文字母、数字或英文字母、数字、下划线的组合，长度控制在3-20个字符之内。</li>
                          <li>真实姓名： 请输入真实的姓名，以便于我们与您联系。该项为隐藏项，用户可以放心输入。</li>
                          <li>密码：请设定在6-20位之间，用户密码及确认密码必须一致。</li>
                          <li>证件号码：请输入正确的证件号码。</li>
                          <li>Email：请填写有效的Email地址，以便于与您联系。</li>
                        </ul></td>
                    </tr>
                    <tr align="center">
                      <td colspan="2" valign="middle" class="word_grey"></td>
                    </tr>
                  </table></td>
                <td width="5" valign="top" background="Images/Cen_separate.gif"></td>
                <td width="73%" valign="top"><table width="100%"
											height="56" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td align="center">&nbsp;</td>
                    </tr>
                    <tr>
                      <td align="center"><form action="register.action" method="post" name="registerform">
                          <table width="100%" border="0" cellspacing="-2"
															cellpadding="-2">
                            <tr> 
                              <script language="javascript">
																	function openwin(UID) {
																		if (UID == "") {
																			alert("请输入用户名!");
																			registerform.username.focus();
																			return;
																		}
																		var str = "checkUsername.action?username=" + UID;
																		window.showModalDialog
																			(str,"","dialogWidth=300px;dialogHeight=150px;status=no;help=no;scrollbars=no");
																	}
																</script>
                              <td width="18%" height="30" align="center">用 户 名：</td>
                              <td width="82%" class="word_grey"><input
																	name="username" type="text" id="Username4"
																	maxlength="20">
                                * [<a href="#"
																	onClick="openwin(registerform.username.value)">检测用户名</a>] 一旦注册不可修改</td>
                            </tr>
                            <tr>
                              <td height="28" align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                              <td height="28"><input name="Password1"
																	type="password" id="Password14" size="20"
																	maxlength="20">
                                *</td>
                            </tr>
                            <tr>
                              <td height="28" align="center">确认密码：</td>
                              <td height="28"><input name="Password2"
																	type="password" id="Password25" size="20"
																	maxlength="20">
                                *</td>
                            </tr>
                            <tr>
                              <td height="28" align="center">用户昵称：</td>
                              <td height="28"><input name="Nickname" type="text"
																	id="Nikename4" maxlength="10">
                                *</td>
                            </tr>
                            <tr>
                              <td height="28" align="center">真实姓名：</td>
                              <td height="28"><input name="Truename" type="text"
																	id="Truename4" maxlength="10"></td>
                            </tr>
                            <tr>
                              <td height="28" align="center">证件类别：</td>
                              <td><input name="CardType" type="radio"
																	class="noborder" value="身份证" checked>
                                身份证&nbsp;
                                <input name="CardType" type="radio" class="noborder"
																	value="军官证">
                                军官证
                                <input name="CardType"
																	type="radio" class="noborder" value="学生证">
                                学生证</td>
                            </tr>
                            <tr>
                              <td height="28" align="center">证件号码：</td>
                              <td class="word_grey"><input name="CardNum"
																	type="text" id="CardNum"></td>
                            </tr>
                            <tr>
                              <td height="28" align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                              <td><input name="Sex" type="radio" class="noborder"
																	value="男" checked>
                                男&nbsp;
                                <input name="Sex"
																	type="radio" class="noborder" value="女">
                                女</td>
                            </tr>
                            <tr>
                              <td height="28" align="center">联系电话：</td>
                              <td><input name="Tel" type="text" id="Tel">
                                *</td>
                            </tr>
                            <tr>
                              <td height="28" align="center" style="padding-left:10px">Email：</td>
                              <td class="word_grey"><input name="Email"
																	type="text" id="Email" size="50">
                                *一旦注册不可修改</td>
                            </tr>
                            <tr>
                              <td height="28" align="center">所在城市：</td>
                              <td><input name="City" type="text" id="City"></td>
                            </tr>
                            <tr>
                              <td height="28" align="center">邮政编码：</td>
                              <td class="word_grey"><input name="ZIP" type="text"
																	id="ZIP" size="20"></td>
                            </tr>
                            <tr>
                              <td height="28" align="center">联系地址：</td>
                              <td class="word_grey"><input name="Address"
																	type="text" id="Address" size="50"></td>
                            </tr>
                            <tr>
                              <td height="34">&nbsp;</td>
                              <td class="word_grey"><input name="Button"
																	type="button" class="btn_grey" value="注册用户"
																	onClick="check()">
                                <input name="Submit2"
																	type="reset" class="btn_grey" value="重新填写">
                                <input
																	name="Submit22" type="button" class="btn_grey"
																	value="返回" onClick="window.location.href='index.jsp'"></td>
                            </tr>
                          </table>
                        </form></td>
                    </tr>
                  </table></td>
              </tr>
            </table>
            <jsp:include page="tail.jsp" /></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>
