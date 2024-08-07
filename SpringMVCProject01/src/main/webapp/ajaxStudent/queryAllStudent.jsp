<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/7
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" rel="script" src="../js/jquery-3.7.1.min.js"></script>
</head>
<body>
<a href="addStudent.jsp">添加学生</a>
<table border="1" id="show">
    <tr><td>学号</td><td>姓名</td><td>密码</td><td>操作</td></tr>
</table>




    <script>
        queryAllStudent();
        function  queryAllStudent(){

            $.ajax({
                url:"queryAllStudent",
                type:"get",
                // data:{},
                dataType:"json",
                success:function(data){
                    // console.log(data);
                    var showObj  = document.getElementById("show");

                    var str  ="<tr><td>学号</td><td>姓名</td><td>密码</td><td>操作</td></tr>";
                    for(var i=0;i<data.length;i++){

                        str  +="<tr>" +
                            "<td>"+data[i].sno+"</td>" +
                            "<td>"+data[i].sname+"</td>" +
                            "<td>"+data[i].password+"</td>" +
                            "<td>" +
                            "<a href='queryStudentBySno?sno="+data[i].sno+"'>编辑</a>|" +
                            "<a href='javascript:deleteStudent("+data[i].sno+")'>删除</a>" +
                            "</td>" +
                            "</tr>";
                    }
                    showObj.innerHTML=str;
                }
            });
        }




        function  deleteStudent(sno){


           var flag  =  window.confirm("是否删除学号是："+sno+"的学生");

            if(flag){



                $.ajax({
                    url:"deleteStudent",
                    type:"get",
                     data:{sno:sno},
                    dataType:"json",
                    success:function(data){

                       if(data){
                            alert("删除成功");

                       }else{

                           alert("删除失败");
                       }
                        queryAllStudent();
                    }
                });





            }





        }




    </script>




</body>
</html>
