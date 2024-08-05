<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/5
  Time: 16:30
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
<form action="student/register.do" method="post">
    姓名: <input name="sname" /><br/>
    密码: <input name="password" type="password"/><br/>
    <input type="submit" name="注册">
</form>

</body>
</html>
