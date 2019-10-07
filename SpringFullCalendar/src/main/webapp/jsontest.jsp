<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
 
     
    $(function() {
         
        // 리스트 생성
        var testList = new Array() ;
         
 
        for(var i=1; i<=2; i++){
             
            // 객체 생성
            var data = new Object() ;
             
            data.number = i ;
            data.name = "Tester #" + i ;
             
             
            // 리스트에 생성된 객체 삽입
            testList.push(data) ;
        }
         
        // String 형태로 변환
        var jsonData = JSON.stringify(testList) ;
         
        alert(jsonData) ;
         
        /*
            출력결과 : [{"number":1,"name":"Tester #1"},{"number":2,"name":"Tester #2"}]
        */
         
    });
     
 
</script>


<body>

</body>
</html>