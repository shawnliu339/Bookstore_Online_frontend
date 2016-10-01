<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>网上图书超市</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache, must-revalidate">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				<table width="777" height="768" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
					<tr>
						<td valign="top">
							<jsp:include page="head.jsp" />
							<table width="100%" height="330" border="0" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="26%" valign="top">
										<jsp:include page="login.jsp" />
										<jsp:include page="guestbookS.jsp"/>
									</td>
									<td width="5" valign="top" background="Images/Cen_separate.gif"></td>
									<td width="73%" valign="top">
										<table width="100%" height="272" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td height="52" colspan="3" background="Images/index_10.gif">
													<jsp:include page="search.jsp" />
												</td>
											</tr>
											<tr>
												<td width="73%" height="220" valign="top">
													<jsp:include page="bookShow.jsp"/>
												</td>
												<td width="5" background="Images/Cen_separate.gif">&nbsp;</td>
												<td valign="top">
													<jsp:include page="history.jsp"/>
													<jsp:include page="salesRankingS.jsp"/>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<jsp:include page="tail.jsp" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>