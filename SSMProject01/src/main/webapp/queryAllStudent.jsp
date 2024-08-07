<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/8/7
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${slist}" var="stu">
    ${stu.sno}-${stu.sname}-${stu.password}<br/>
</c:forEach>



</body>
</html>
