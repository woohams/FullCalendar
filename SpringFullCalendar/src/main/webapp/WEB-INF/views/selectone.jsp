<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type="hidden" name="id" value="${dto.id }">
		<table border="1">
			<tr>
				<th>I   D</th>
				<td>${dto.id }</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td>${dto.password }</td>
			</tr>
			<tr>
				<th>N A M E</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='update.do?id=${dto.id}'">
					<input type="button" value="삭제" onclick="location.href='delete.do?id=${dto.id}'">
					<input type="button" value="목록" onclick="location.href='list.do'"> 
				</td>
			</tr>
			
			
		</table>
		
	

</body>
</html>