<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/7
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 修改成功
<table border="1">
    <tr><td>学号</td><td>${student.sno}</td></tr>
    <tr><td>学号</td><td>${student.sname}</td></tr>
    <tr><td>学号</td><td>${student.password}</td></tr>
    <tr><td>学号</td><td><img width="200px" src="../${student.photo}"></td></tr>
    <tr><td>学号</td>
        <td>
            <a href="../${student.resume}" download >我的简历</a>
            <%-- 关于  download 属性  :直接下载  如果没有，图片 pdf等等 是直接打开的--%>
            <%-- 关于  download 属性  的值：如果有设值 ，下载的文件 以  值的内容  定义（命名） 文件名（包括后缀） --%>
<%--        <a href="../${student.resume}" download="xxx.pdf" >我的简历</a>--%>
    </td></tr>
</table>


</body>
</html>
