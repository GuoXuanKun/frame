<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/8/5
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<%-- 注意 斜杠  --%>
<form action="student/login" method="post">
    姓名: <input name="sno" /><br/>
    密码: <input name="password" type="password"/><br/>
    <input type="submit" name="注册">
</form>

</body>
</html>