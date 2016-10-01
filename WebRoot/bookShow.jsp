<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="mybookapp1.DTO.Book" %>


    <table width="100%" height="126" border="0" cellpadding="0" cellspacing="0">
      <c:forEach items="${requestScope.books }" var="book" varStatus="i">
        <c:if test="${i.count %2 != 0}">
          <tr>
            <td width="50%" align="center"><table width="100%" height="123" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="43%" align="center"><img src="Images/BookCover/${book.img }" width="76" height="110"></td>
                  <td width="57%"><table width="100%" height="119" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td>${book.name }</td>
                      </tr>
                      <tr>
                        <td>${book.publisher }</td>
                      </tr>
                      <tr>
                        <td>作者：${book.author }</td>
                      </tr>
                      <tr>
                        <td>定价：${book.price }（元）</td>
                      </tr>
                      <tr>
                        <td align="center"><c:if test="${!empty sessionScope.user }">
                            <input name="Submit5" type="submit" class="btn_grey" value="购买" onClick="window.location.href='cartAdd.action?id=${book.id}'">
                          </c:if>
                          <input name="Submit6" type="submit" class="btn_grey" value="查看" onClick="window.location.href='bookdetail.action?id=${book.id}'"></td>
                      </tr>
                    </table></td>
                </tr>
              </table></td>
        </c:if>
        <c:if test="${i.count %2 == 0}">
          <td width="50%" align="center"><table width="100%" height="123" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="43%" align="center"><img src="Images/BookCover/${book.img }" width="76" height="110"></td>
                <td width="57%" align="center"><table width="100%" height="119" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>${book.name }</td>
                    </tr>
                    <tr>
                      <td>${book.publisher }</td>
                    </tr>
                    <tr>
                      <td>作者：${book.author }</td>
                    </tr>
                    <tr>
                      <td>定价：${book.price }（元）</td>
                    </tr>
                    <tr>
                      <td align="center"><c:if test="${!empty sessionScope.user }">
                          <input name="Submit5" type="submit" class="btn_grey" value="购买" onClick="window.location.href='cartAdd.action?id=${book.id}'">
                        </c:if>
                        <input name="Submit6" type="submit" class="btn_grey" value="查看" onClick="window.location.href='bookdetail.action?id=${book.id}'"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
            </tr>
          
        </c:if>
      </c:forEach>
    </table>
