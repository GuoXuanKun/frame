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



<form action="user/addUserAndAddress" method="get">
    用户id：<input name="uid"/><br/>
    姓名：<input name="username"/><br/>
    密码：<input name="password"/><br/>

    地址1：<br/>
    地址id：<input name="addressList[0].aid"/><br/>
    收件人：<input name="addressList[0].name"/><br/>

    地址2：<br/>
    地址id：<input name="addressList[1].aid"/><br/>
    收件人：<input name="addressList[1].name"/><br/>




    <br/>


    <input type="submit"/>


</form>





</body>
</html>
