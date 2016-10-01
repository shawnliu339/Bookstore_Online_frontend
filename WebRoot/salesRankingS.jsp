<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table width="100%" height="55" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<!-- 销量排行  -->
		<td align="right"><img src="Images/index_16.gif" width="161"
			height="48"></td>
	</tr>
	<tr>
		<td width="86%" height="100" valign="top" class="tableBorder_B">
			<c:forEach items="${requestScope.rankList }" var="rank">
			<table width="100%" height="21" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="9%"><img src="Images/greendot.gif" width="11" height="13"></td>
					<td width="91%" style="padding:5px;"><a href="bookdetail.action?id=${pageScope.rank.bookId }" />${pageScope.rank.name }</td>
				</tr>
			</table>
			</c:forEach>
		</td>
	</tr>
</table>

