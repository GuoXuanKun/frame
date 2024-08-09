<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/8
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<c:remove var="msg"></c:remove>

<form action="addStudent" method="post">
    <input name="sno" readonly /><br/>
    <input name="sname" /><br/>
    <input name="password"   /><br/>
    <input type="submit" />
</form>



</body>
</html>
