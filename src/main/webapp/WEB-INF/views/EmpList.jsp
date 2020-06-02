<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/26
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Emplist</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <script>
        function changePageSize() {
            //获取下拉框的值
            var pageSize = $("#changePageSize").val();

            //向服务器发送请求，改变没页显示条数
            location.href = "${pageContext.request.contextPath}/emp/list?page=1&size="
                + pageSize;
        }

        $(function () {
            $("#add").click(function () {
                location.href = "/add";
            });
            $(".del").click(function () {
                var id = $(this).val();
                location.href = "/emp/del?id=" + id;
            });
            $(".upd").click(function () {
                var id = $(this).val();
                location.href = "/emp/huixian?id=" + id;
            });
        })

        function checks(obj) {
            $(".one").prop("checked", obj.checked);
        }

        $(function () {
            $("#dels").click(function () {
                //$("#form").submit();
                $.ajax({
                    url: "${pageContext.request.contextPath}/emp/dels",
                    data: $("#form").serialize(),
                    dataType: "json",
                    success: function (data) {
                        layer.msg("操作成功！");
                    },
                    error: function (data) {
                        layer.msg("操作失败！");
                    }
                })
            });
        })

    </script>
</head>
<body>
<button type="button" id="add">添加</button>
<button type="button" id="dels">删除选中</button>
<form method="post" action="" id="form">
    <table border="1">
        <tr>
            <td><input type="checkbox" onclick="checks(this)"/></td>
            <td>#</td>
            <td>EmpName</td>
            <td>age</td>
            <td>email</td>
            <td>birth</td>
            <td>deptId</td>
            <td>name</td>
            <td>salary</td>
            <td>
                option
            </td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="emp" varStatus="index">
            <tr>
                <td><input type="checkbox" class="one" name="ids" value="${emp.id}"/></td>
                <td>${index.count}</td>
                <td>${emp.empName}</td>
                <td>${emp.age}</td>
                <td>${emp.email}</td>
                <td>${emp.birstr}</td>
                <td>${emp.dept.id}</td>
                <td>${emp.dept.name}</td>
                <td>${emp.dept.salary}</td>
                <td>
                    <button type="button" class="del" value="${emp.id}">删除</button>
                    <button type="button" class="upd" value="${emp.id}">修改</button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <div class="box-footer">
                <div class="pull-left">
                    <div class="form-group form-inline">
                        总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页
                        <select class="form-control" id="changePageSize" onchange="changePageSize()">
                            <option class="active">${pageInfo.pageSize}</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select> 条,当前第${pageInfo.pageNum} 页。
                    </div>
                </div>
            </div>
            <div class="box-tools pull-right">
                <ul class="pagination">
                    <li>
                        <a href="${pageContext.request.contextPath}/emp/list?page=1&size=${pageInfo.pageSize}"
                           aria-label="Previous">首页</a>
                    </li>
                    <li <c:if test="${pageInfo.pageNum==1}">class="disabled" </c:if>><a
                            href="${pageContext.request.contextPath}/emp/list?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                    </li>
                    <c:if test="${pageInfo.pages>5&&pageInfo.pages<pageInfo.pageNum+4}">
                        <c:forEach begin="${pageInfo.pages-4}" end="${pageInfo.pages}" var="pageNum">
                            <li>
                                <a href="${pageContext.request.contextPath}/emp/list?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${pageInfo.pages>5&&pageInfo.pages>=pageInfo.pageNum+4}">
                        <c:forEach begin="${pageInfo.pageNum}" end="${pageInfo.pageNum+4}" var="pageNum">
                            <li>
                                <a href="${pageContext.request.contextPath}/emp/list?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                    <c:if test="${pageInfo.pages<=5}">
                        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                            <li>
                                <a href="${pageContext.request.contextPath}/emp/list?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                    <li <c:if test="${pageInfo.pageNum==pageInfo.pages}">class="disabled" </c:if>>
                        <c:if test="${pageInfo.pageNum==pageInfo.pages}">
                        <a href="${pageContext.request.contextPath}/emp/list?page=${pageInfo.pageNum}&size=${pageInfo.pageSize}">
                            </c:if>
                            <c:if test="${pageInfo.pageNum<pageInfo.pages}">
                            <a href="${pageContext.request.contextPath}/emp/list?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">
                                </c:if>
                                下一页</a></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/emp/list?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                           aria-label="Next">尾页</a>
                    </li>
                </ul>
            </div>
        </tr>
    </table>
</form>
</body>
</html>
