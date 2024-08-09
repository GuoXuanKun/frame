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

<form action="modifyStudentResume" method="post" enctype="multipart/form-data">
    学号：<input type="text" name="sno"><br/>
    上传简历： <input type="file" name="resume"/><br/>
    <input type="submit" />
</form>


</body>
</html>
