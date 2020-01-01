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

<body>
<div class="x-body layui-anim layui-anim-up">
    <form class="layui-form" method="post">
        <input type="hidden" name="studyId" value="${study.studyId}">
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_username" name="studyTitle" required lay-verify="studyTitle"
                       autocomplete="off" class="layui-input" value="${study.studyTitle}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>参与成员
            </label>
            <div class="layui-input-inline">
                <c:forEach items="${userList}" var="user">
                    <c:if test="${study.userList.contains(user)}">
                        <input type="checkbox" name="studyUser" title="${user.name}" value="${user.username}" checked lay-skin="primary">
                    </c:if>
                    <c:if test="${!study.userList.contains(user)}">
                        <input type="checkbox" name="studyUser" title="${user.name}" value="${user.username}" lay-skin="primary">
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>学习内容
            </label>
            <div class="layui-input-inline">
                <textarea name="studyContent" class="layui-textarea">${study.studyContent}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_username" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>
    </form>
</div>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });
    });
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(add)', function (data) {
            //获取checkbox[name='foodId']的值，获取所有选中的复选框，并将其值放入数组中
            var arr = [];
            $("input:checkbox[name='studyUser']:checked").each(function (i) {
                arr[i] = $(this).val();
            });
            if (arr.length > 0) {
                //  替换 data.field.foodId的数据为拼接后的字符串
                data.field.studyUser = "'" + arr.join("','") + "'";//将数组合并成字符串
            }
            console.log(JSON.stringify(data.field));
            $.ajax({
                url: "${pageContext.request.contextPath}/study/update.action",
                data: JSON.stringify(data.field),
                contentType: "application/json;charset=UTF-8",
                type: "post",
                dataType: "json",
                success: function (dep) {
                    if (dep.code == 200) {
                        layer.alert(dep.msg, {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            parent.location.href = "${pageContext.request.contextPath}/study/list.action"
                        });
                    }
                }
            });

            return false;
        });

    });
</script>
</body>

</html>
