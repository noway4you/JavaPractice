<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.test.bcrypt.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:if test="${empty member.account}">
	<c:redirect url="JSP33_LogIn.jsp"></c:redirect>
</c:if>
<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/brad"
		user="root"
		password="root"
/>
<c:if test="${!empty param.account}">
	<c:if test="${pageContext.request.method != 'POST'}"><c:redirect url="JSP33_LogOut.jsp"></c:redirect></c:if>
	<sql:update>
		update member set account = ?,password = ?,name = ? where id = ?
		<sql:param>${param.account}</sql:param>	
		<sql:param>${BCrypt.hashpw(param.password,BCrypt.gensalt())}</sql:param>	
		<sql:param>${param.name}</sql:param>	
		<sql:param>${param.id}</sql:param>	
	</sql:update>
</c:if>
<c:if test="${!empty param.editID}">
	<sql:query var="result">
		select * from member where id = ?
		<sql:param>${param.editID}</sql:param>
	</sql:query>
	<c:if test="${result.rowCount == 0}"><c:redirect url="JSP33_MainPage.jsp"></c:redirect></c:if>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Edit Member Page
		<hr>
		<form method="post">
			<input type="hidden" name="id" value="${result.rows[0].id}">
			Account:<input name="account" value="${result.rows[0].account}"><br><br>
			Password:<input type="password" name="password"><br><br>
			Name:<input name="name" value="${result.rows[0].name}"><br><br>
			<input type="submit" value="Update">
		</form>
	</body>
</html>