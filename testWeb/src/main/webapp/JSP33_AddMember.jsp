<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.test.bcrypt.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<c:if test="${empty member.account}">
	<c:redirect url="LogIn.jsp"></c:redirect>
</c:if>
<c:if test="${!empty param.account}">
	<c:if test="${pageContext.request.method != 'POST'}"><c:redirect url="LogIn.jsp"></c:redirect></c:if>
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/brad"
		user="root"
		password="root"
	/>
	<sql:update>
		insert into member (account,password,name) values (?,?,?)
		<sql:param>${param.account}</sql:param>	
		<sql:param>${BCrypt.hashpw(param.password,BCrypt.gensalt())}</sql:param>	
		<sql:param>${param.name}</sql:param>	
	</sql:update>
	<c:redirect url="MainPage.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Add Member Page
		<hr>
		<form method="post">
			Account:<input name="account"><br><br>
			Password:<input type="password" name="password"><br><br>
			Name:<input name="name"><br><br>
			<input type="submit" value="Add">
		</form>
	</body>
</html>