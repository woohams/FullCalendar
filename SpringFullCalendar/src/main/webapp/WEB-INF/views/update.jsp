<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="updateres.do" method="post">
	<input type="hidden" name="id" value="${dto.id }"/>
		<table border="1">
			<tr>
				<th>I   D</th>
				<td><input type="text" readonly="readonly" value="${dto.id }"/></td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input type="text" name="password" value="${dto.password }"/></td>
			</tr>
			<tr>
				<th>N A M E</th>
				<td><input type="text" name="name" value="${dto.name }"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 완료"/>
					<input type="button" value="뒤로 가기" onclick="location.href='selectone.do?id=${dto.id}'"/>
					<input type="button" value="목록" onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>