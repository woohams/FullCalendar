<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">


	$(function(){
		$("#loginchk").hide();
	});

	function login(){
		var idVal = $("#id").val();
		var pwVal = $("#password").val();
		
//		alert(idVal + ":" + pwVal);
		
		if(idVal == ""||idVal == null){
			alert("ID를 다시 한번 확인해 주세요.");
		} else if(pwVal == "" || pwVal == null){
			alert("Password를 다시 한번 확인해 주세요.");
		} else {
			$("#loginchk").show();
			
			$.ajax({
				type:"post",
				url:"loginajax.do",
				data:"id="+idVal+"&password="+pwVal,
				success:function(msg){
					alert(msg.loginchk);
					//console.log(msg);
					if(msg.loginchk == true){
						location.href='list.do';
					}else{
						document.getElementById("loginchk").innerHTML="ID 혹은 Password를 다시한번 확인해 주세요.";
					}
						
				},
				error:function(){
					alert("로그인 실패!");
				}
			})
			
		}
	}

</script>



<body>

	<h1>L O G I N</h1>
	
	<table border="1">
		<tr>
			<th>I D</th>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><input type="text" id="password"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="login" onclick="login()"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginchk"></td>
		</tr>
	</table>

</body>
</html>