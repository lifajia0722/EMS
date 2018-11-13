<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
</head>
<body>
    <h1>注册</h1>
    <form action="${pageContext.request.contextPath}/user/add" method="post" enctype="multipart/form-data">
        法号：<input type="text" name="username" /><br/>
        用户名：<input type="text" name="phoneNum" /><br/>
        密码：<input type="password" name="password" /><br/>
        <input type="submit" value="点我">
    </form><hr><br>

    <h1>登录</h1>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名：<input type="text" name="phoneNum" /><br />
        密码：<input type="password" name="password" /><br />
        <input type="submit" value="登录"><hr><br>
    </form><hr><br>

    <h1>修改</h1>
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        id:<input type="text" name="id" /><br />
        用户名：<input type="text" name="phoneNum" /><br />
        密码：<input type="password" name="password" /><br />
        <input type="submit" value="点我"><hr><br>
    </form><hr><br>

</body>
</html>
