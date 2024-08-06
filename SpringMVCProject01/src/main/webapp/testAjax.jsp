<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/6
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <script src="js/jquery-3.7.1.min.js" type="text/javascript" rel="script"></script>

    <button onclick="test1()">测试：ajax dataType:text </button>

<script>
    function test1(){
        $.ajax({
            url:"classroom/queryCnameByCno",
            type:"get",
            data:{
                cno:"666"
            },
            dataType:"text",
            success:function (data){
                console.log(data);
            }
        });
    }

</script>



    <button onclick="test2()">测试：ajax dataType:json </button>

    <script>
        function test2(){
            $.ajax({
                url:"classroom/queryStudentByCno",
                type:"get",
                data:{
                    cno:"666"
                },
                dataType:"json",
                success:function (data){
                    console.log(data);
                }
            });
        }

    </script>



    <button onclick="test3()">测试：ajax dataType:json   查询全部 </button>

    <script>
        function test3(){
            $.ajax({
                url:"classroom/queryAllStudent",
                type:"get",
                dataType:"json",
                success:function (data){
                    console.log(data);
                }
            });
        }

    </script>


</body>
</html>
