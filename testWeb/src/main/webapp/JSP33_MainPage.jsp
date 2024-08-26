<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty member.account}">
	<c:redirect url="LogIn.jsp"></c:redirect>
</c:if>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost/brad"
	user="root"
	password="root"
/>
<c:if test="${!empty param.deleteID}">
	<sql:update>
		delete from member where id = ?
		<sql:param>${param.deleteID}</sql:param>
	</sql:update>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Welcome , ${member.account}<br>		
		<a href="JSP33_LogOut.jsp">LogOut</a><br>
		<a href="JSP33_AddMember.jsp">Add Member</a>
		<hr>
		<table border="1" width="100%">
			<tr>
				<th>ID</th>
				<th>Account</th>
				<th>Password</th>
				<th>Delete</th>
			</tr>
			<sql:query var="result">select * from member</sql:query>
			<script>
				function isDelete(who){
					var isDelete = confirm("Do you want to delete "+who+" ?")
					return isDelete
				}
			</script>
			<c:forEach var="row" items="${result.rows}">
				<tr>
					<td>${row.id}</td>
					<td>${row.account}</td>
					<td>${row.password}</td>
					<td><a href="?deleteID=${row.id}" onclick="return isDelete('${row.name}')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>