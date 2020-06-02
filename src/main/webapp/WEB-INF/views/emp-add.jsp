<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/27
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>emp-add</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="static/layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#add").click(function () {
                var emp = {
                        "empName": $("#empName").val(),
                        "age": $("#age").val(),
                        "email": $("#email").val(),
                        "birth": $("#birth").val(),
                        dept: {
                            "id": $("#dept-id").val()
                        }

                    }
                ;
                $.ajax({
                    url: "${pageContext.request.contextPath}/emp/add",
                    type: "post",
                    data: JSON.stringify(emp),
                    dataType: "json",
                    contentType: "application/json;charset=UTF-8",
                    success: function (data) {
                        layer.msg("添加成功！");
                    },
                    error: function (data) {
                        layer.msg("操作失败！");
                    }
                });
            });

        })
        $(function () {
            $("#reset").click(function () {
                location.href = "${pageContext.request.contextPath}/emp/list";
            });
        })
        $(function () {
            $.ajax({
                url:"/dept/list",
                type:"post",
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success:function (data) {
                    layer.msg(data.length);
                    $.each(data,function (i,n) {
                        var name=data[i].name;
                        var id=data[i].id;
                        var opt=document.createElement("option");
                        opt.value=id;
                        opt.text=name;
                        $("#dept-id").append(opt);
                    })
                },
                error:function (data) {
                    layer.msg("页面加载失败！");
                }
            })
        })
    </script>
</head>
<body>
<table>
    <tr>
        <td>EmpName</td>
        <td><input type="text" name="empName" id="empName"/></td>
    </tr>
    <tr>
        <td>age</td>
        <td><input type="text" name="age" id="age"/></td>
    </tr>
    <tr>
        <td>email</td>
        <td><input type="email" name="email" id="email"/></td>
    </tr>
    <tr>
        <td>birth</td>
        <td><input type="date" name="birth" id="birth"/></td>
    </tr>
    <tr>
        <td>department</td>
        <td>
            <select name="dept.id" id="dept-id">

            </select>
        </td>
    </tr>
    <tr>
        <td>
            <button type="button" id="add">增加</button>
        </td>
        <td>
            <button type="reset" id="reset">返回</button>
        </td>
    </tr>
</table>
</body>
</html>
