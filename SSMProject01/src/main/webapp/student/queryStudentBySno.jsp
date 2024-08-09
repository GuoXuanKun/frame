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
${msg}
<c:remove var="msg"></c:remove>
<body>
    <form action="modifyStudent" method="post">
        <input name="sno" value="${student.sno}" readonly /><br/>
        <input name="sname" value="${student.sname}"  /><br/>
        <input name="password" value="${student.password}"  /><br/>
        <input type="submit" />
    </form>


</body>
</html>
