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
         
        // ����Ʈ ����
        var testList = new Array() ;
         
 
        for(var i=1; i<=2; i++){
             
            // ��ü ����
            var data = new Object() ;
             
            data.number = i ;
            data.name = "Tester #" + i ;
             
             
            // ����Ʈ�� ������ ��ü ����
            testList.push(data) ;
        }
         
        // String ���·� ��ȯ
        var jsonData = JSON.stringify(testList) ;
         
        alert(jsonData) ;
         
        /*
            ��°�� : [{"number":1,"name":"Tester #1"},{"number":2,"name":"Tester #2"}]
        */
         
    });
     
 
</script>


<body>

</body>
</html>