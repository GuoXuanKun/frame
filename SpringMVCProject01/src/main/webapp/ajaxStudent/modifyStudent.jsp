<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/7
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" rel="script" src="../js/jquery-3.7.1.min.js"></script>
</head>
<body>

<%-- ajax方式 添加 --%>
学号：<input id="sno" value="${student.sno}"  disabled/><br/>
姓名：<input id="sname" value="${student.sname}"/><br/>
密码：<input id="password" type="password" value="${student.password}"/><br/>

<button onclick="modifyStudent()">修改</button><br/>



<script>

    function  modifyStudent(){

        var sno = document.getElementById("sno").value;
        var sname = document.getElementById("sname").value;
        var password = document.getElementById("password").value;
        debugger
        $.ajax({
            url:"modifyStudent",
            type:"post",
            data:{
                sno:sno,
                "sname":sname,
                "password":password
            },
            dataType:"json",
            success:function (data){
                debugger
                console.log(data);
                if(data){
                    alert("修改成功");
                    // location.href="queryAllStudent.jsp";

                }else{
                    alert("修改失败");
                }


            }

        });



    }

</script>



</body>
</html>
