<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/27
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>emp-update</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "/dept/list",
                type: "post",
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    $.each(data, function (i, n) {
                        var name = data[i].name;
                        var id = data[i].id;
                        var option = document.createElement("option");
                        option.value = id;
                        option.text = name;
                        if (id==${emp.dept.id}){
                            option.selected=true;
                        }
                        $("#select").append(option);

                    })
                },
                error: function (data) {
                    layer.msg("页面加载失败！");
                }
            })
        })

        $(function () {
            $("#upd").click(function () {
                var emps = {
                    "id": $("#eid").val(),
                    "empName": $("#empName").val(),
                    "age": $("#age").val(),
                    "email": $("#email").val(),
                    "birth": $("#birth").val(),
                    dept: {
                        "id": $("#select").val()
                    }
                };
                //layer.msg(emps);
                $.ajax({
                    url: "/emp/update",
                    type: "post",
                    dataType: "json",
                    data: JSON.stringify(emps),
                    contentType: "application/json;charset=UTF-8",
                    success: function (data) {
                        layer.msg("更新成功！");
                    },
                    error: function (data) {
                        layer.msg("更新失败！");
                    }
                })
            });
        })
    </script>
</head>
<body>
<input type="hidden" name="id" value="${emp.id}" id="eid"/>
<table>
    <tr>
        <td>EmpName</td>
        <td><input type="text" name="empName" id="empName" value="${emp.empName}"/></td>
    </tr>
    <tr>
        <td>age</td>
        <td><input type="text" name="age" id="age" value="${emp.age}"/></td>
    </tr>
    <tr>
        <td>email</td>
        <td><input type="email" name="email" id="email" value="${emp.email}"/></td>
    </tr>
    <tr>
        <td>birth</td>
        <td><input type="text" name="birth" id="birth" value="${emp.birstr}"/></td>
    </tr>
    <tr>
        <td>department</td>
        <td>
            <select name="dept.id" id="select">

            </select>
        </td>
    </tr>
    <tr>
        <td>
            <button type="button" id="upd">更新</button>
        </td>
        <td>
            <button type="reset" id="reset">返回</button>
        </td>
    </tr>
</table>
</body>
</html>
