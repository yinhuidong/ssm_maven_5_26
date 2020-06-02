<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="static/layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sign").click(function () {
                var arr = {name: $("#name").val(), password: $("#password").val()};
                var jsons = JSON.stringify(arr);
                $.ajax({
                    url: "login",
                    type: "post",
                    data: jsons,
                    //dataType: "json",
                    contentType: "application/json;charset=UTF-8",
                    success: function (data) {
                        layer.msg("登陆成功！");
                        setTimeout(function () {
                            location.href = "emp/list";
                        },2000);

                    },
                    error: function (data) {
                        //var a = data.responseJSON;

                            layer.msg(data);

                    }
                });
            });
        })
    </script>
</head>
<body>
<h1>
    <form>
        <span>用户名</span><input type="text" name="name" id="name"/><br/>
        <span>密码</span><input type="password" name="password" id="password"/><br/>
        <button id="sign" type="button">登录</button>
    </form>
</h1>
</body>
</html>