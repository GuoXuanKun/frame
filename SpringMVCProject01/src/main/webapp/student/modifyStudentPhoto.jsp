<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/7
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="modifyStudentPhoto" method="post" enctype="multipart/form-data">
    学生姓名：<input type="text" name="sno"><br/>
    上传头像： <input type="file" name="photo"/><br/>
    <input type="submit" />
</form>


</body>
</html>
