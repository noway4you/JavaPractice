<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>times table</h1>
		<form>
		    Start = <input type="number" name="start">
			Row x Col = <input type="number" name="rows">x<input type="number" name="cols">
			<input type="submit" value="change">
		</form>
		<table border="1" width="100%">
			<%
				
				int count = 0;
				out.print("<tr>");
				for(int i=2;i<=9;i++){
					count++;
					if(count==5) out.print("</tr><tr>");
					out.println("<td>");	
					for(int j=1;j<=9;j++){
						out.print(i+"x"+j+"="+i*j+"<br>");
					}
					out.println("</td>");
				}
				out.print("</tr>");
			%>
		</table>
	</body>
</html>