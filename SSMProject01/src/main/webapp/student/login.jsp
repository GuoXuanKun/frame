<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/8/9
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
     String msg  = session.getAttribute("msg");
     session.removeAttribute("msg");
      <%=msg%>
--%>

<h1>${msg}</h1>



<form action="login">

        <input type="submit" value="登录"/>
</form>

</body>
</html>
