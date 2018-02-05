<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.equabank.skoleni.EmailResponse"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ahoj</title>
</head>
<body>
	<h1>Moje prvni stranka</h1>
	Ahoj lidi :-).
	<p>je email validni?</p>
	<%
		EmailResponse emailResponse = (EmailResponse)request.getAttribute("emailResponse");
	%>
	<table>
		<tr>
			<td>Email:</td>
			<td><%=emailResponse.getId()%></td>
		</tr>
		<tr>
			<td>Je validni:</td>
			<td><%=emailResponse.isExist()%></td>
		</tr>		
	</table>
	<a href="./checkEmail" >Zpet na kontrolu emailu</a>
</body>
</html>