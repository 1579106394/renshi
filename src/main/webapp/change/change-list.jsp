<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
    <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="listForm" method="post"
              action="${pageContext.request.contextPath}/postionChange/list.action">
            <input type="hidden" name="currentPage" value="${page.currentPage}" id="currentPage">
            <input type="text" name="params[name]" placeholder="姓名" autocomplete="off" class="layui-input"
                   value="${page.params.name}">
            <input type="text" name="params[username]" placeholder="账号" autocomplete="off" class="layui-input"
                   value="${page.params.username}">
            <input type="text" name="params[oldPosition]" placeholder="旧职位" autocomplete="off" class="layui-input"
                   value="${page.params.oldPosition}">
            <input type="text" name="params[newPosition]" placeholder="新职位" autocomplete="off" class="layui-input"
                   value="${page.params.newPosition}">
            <div class="layui-form-item" style="width: 150px;display: inline-block">
                <select name="params[sex]" lay-verify="required">
                    <option value=""></option>
                    <c:if test="${page.params.sex eq '男'}">
                        <option value="男" selected>男</option>
                        <option value="女">女</option>
                    </c:if>
                    <c:if test="${page.params.sex eq '女'}">
                        <option value="男">男</option>
                        <option value="女" selected>女</option>
                    </c:if>
                    <c:if test="${empty page.params.sex}">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </c:if>
                </select>
            </div>
            <button class="layui-btn" type="submit"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <span class="x-right" style="line-height:40px">共有数据：${page.totalCount} 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>账号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>照片</th>
            <th>变更前</th>
            <th>变动后</th>
            <th>变更时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="change">
            <tr>
                <td>${change.user.username}</td>
                <td>${change.user.name}</td>
                <td>${change.user.age}</td>
                <td>${change.user.sex}</td>
                <td>${change.user.img}</td>
                <td>${change.oldPosition.positionName}</td>
                <td>${change.newPosition.positionName}</td>
                <td>${change.changeTime}</td>
                <td class="td-manage">
                    <a title="删除" class="layui-btn layui-btn-sm layui-btn-danger"
                       onclick="member_del(this,'${change.changeId}')"
                       href="javascript:;">
                        删除
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <c:if test="${page.currentPage != 1}">
                <a class="prev"
                   href="javascript:void(0);" onclick="submitForm(${page.currentPage-1})">&lt;&lt;</a>
            </c:if>
            <c:forEach begin="1" end="${page.totalPage}" var="p">
                <c:if test="${page.currentPage != p}">
                    <a class="num"
                       href="javascript:void(0);" onclick="submitForm(${p})">${p}</a>
                </c:if>
                <c:if test="${page.currentPage == p}">
                    <span class="current">${p}</span>
                </c:if>
            </c:forEach>
            <c:if test="${page.totalPage != page.currentPage}">
                <a class="next"
                   href="javascript:void(0);" onclick="submitForm(${page.currentPage+1})">&gt;&gt;</a>
            </c:if>
        </div>
    </div>

</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    function submitForm(p) {
        $("#currentPage").val(p)
        $("#listForm").submit()
    }

    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                url: "${pageContext.request.contextPath}/leave/delete.action",
                data: "{\"changeId\":\"" + id + "\"}",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                dataType: "json",
                success: function (dep) {
                    if (dep.code == 200) {
                        layer.alert(dep.msg, {icon: 6}, function () {
                            window.location.href = "${pageContext.request.contextPath}/postionChange/list.action"
                        });
                    }
                }
            });
        });
    }
</script>
</body>

</html>
