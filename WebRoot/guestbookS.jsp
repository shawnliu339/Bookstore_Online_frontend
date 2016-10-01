<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="50" colspan="2" align="right"><img src="Images/index_20.gif" width="185" height="50"></td>
            </tr>
            
            <tr>
              <td width="14%"></td>
              <td height="100" valign="top"><form name="form3" method="post" action="guestbookAdd.action">
                <table width="100%" height="151"  border="0" align="center" cellpadding="0" cellspacing="0">
                  <c:choose>
                  	<c:when test="${empty sessionScope.user }">
                  	  <c:set var="guestbookContent" value="请您登录后再进行操作！"/>
                  	</c:when>
                  </c:choose>
                  <tr>
                  	<td>用户名：</td>
                  </tr>
                  <tr>
                    <td><input name="username" type="text" size="15" value="${sessionScope.user.username }" readonly="readonly"></td>
                  </tr>
                  <tr>
                  <td>主&nbsp;&nbsp;题：</td>
                  </tr>
                  <tr>
                    <td height="36">
                      	<input name="title" type="text" size="25">
                    </td>
                  </tr>
                  <tr>
                  	<td>内&nbsp;&nbsp;容：</td>
                  </tr>
                  <tr>
                    <td>
                      	<textarea name="content" cols="20" rows="10">${pageScope.guestbookContent }</textarea>
                    </td>
                  </tr>
                  <tr>
                    <td align="center">
                      <input name="Submit7" type="submit" class="btn_grey" value="提交">
                      <input name="Submit8" type="reset" class="btn_grey" value="全部重写">
                    </td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table>
