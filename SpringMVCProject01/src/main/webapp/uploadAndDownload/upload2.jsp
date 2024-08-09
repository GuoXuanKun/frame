<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/7
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


  <form action="upload2" method="post" enctype="multipart/form-data">
      学生姓名：<input type="text" name="sname"><br/>
      上传头像： <input type="file" name="photo"/><br/>
      上传简历：   <input type="file" name="resume"/><br/>

      <input type="submit" />



  </form>


</body>
</html>
