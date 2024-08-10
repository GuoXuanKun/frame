<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/7
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}<br/>
${info}<br/>
<c:remove var="msg"></c:remove>

<c:forEach items="${slist}" var="stu">
    ${stu.sno}-${stu.sname}-${stu.password}-
    <a href="deleteStudentBySno?sno=${stu.sno}">删除</a>|
    <a href="queryStudentBySno?sno=${stu.sno}">查询/编辑</a><br/>
</c:forEach>

<a href="addStudent.jsp">新增学生</a>

</body>
</html>
