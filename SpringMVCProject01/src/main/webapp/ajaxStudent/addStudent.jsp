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
        姓名：<input id="sname"/><br/>
        密码：<input id="password" type="password"/><br/>

        <button onclick="addStudent()">添加</button><br/>



        <script>

            function  addStudent(){


               var sname = document.getElementById("sname").value;
                var password = document.getElementById("password").value;

                $.ajax({
                    url:"addStudent",
                    type:"post",
                    data:{
                        "sname":sname,
                        "password":password
                    },
                    dataType:"json",
                    success:function (data){
                        debugger
                        console.log(data);
                        if(data>0){
                            alert("添加成功，学号为："+data);
                            location.href="queryAllStudent.jsp";

                        }else{
                            alert("添加失败");
                        }


                    }

                });



            }

        </script>



</body>
</html>
