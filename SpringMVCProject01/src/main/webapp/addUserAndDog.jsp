<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/6
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<form action="user/addUserAndDog" method="get">
    用户id：<input name="uid"/><br/>
    姓名：<input name="username"/><br/>
    密码：<input name="password"/><br/>

    狗的id：<input name="dog.did"/><br/>
    狗的姓名：<input name="dog.dname"/><br/>
    狗的性别：<input name="dog.sex"/><br/>

    <br/>


    <input type="submit"/>


</form>





</body>
</html>
