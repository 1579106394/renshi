<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="index.jsp">L-admin v2.0</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onClick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
                <dd><a href="${pageContext.request.contextPath}/user/logout.action">退出</a></dd>
            </dl>
        </li>
    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6eb;</i>
                    <cite>主页</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="${pageContext.request.contextPath}/html/welcome.html"><i class="iconfont">&#xe6a7;</i><cite>控制台</cite></a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>部门管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/position/list.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>部门列表</cite>

                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="${pageContext.request.contextPath}/user/list.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>用户列表</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="${pageContext.request.contextPath}/leave/list.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>离职记录</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="${pageContext.request.contextPath}/postionChange/list.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>职位变动</cite>

                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6e4;</i>
                    <cite>基本元素</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="html/unicode.html"><i class="iconfont">&#xe6a7;</i><cite>图标字体</cite></a></li>
                    <li><a _href="html/form1.html"><i class="iconfont">&#xe6a7;</i><cite>表单元素</cite></a></li>
                    <li><a _href="html/form2.html"><i class="iconfont">&#xe6a7;</i><cite>表单组合</cite></a></li>
                    <li><a _href="html/buttons.html"><i class="iconfont">&#xe6a7;</i><cite>按钮</cite></a></li>
                    <li><a _href="html/nav.html"><i class="iconfont">&#xe6a7;</i><cite>导航/面包屑</cite></a></li>
                    <li><a _href="html/tab.html"><i class="iconfont">&#xe6a7;</i><cite>选项卡</cite></a></li>
                    <li><a _href="html/progress-bar.html"><i class="iconfont">&#xe6a7;</i><cite>进度条</cite></a></li>
                    <li><a _href="html/panel.html"><i class="iconfont">&#xe6a7;</i><cite>面板</cite></a></li>
                    <li><a _href="html/badge.html"><i class="iconfont">&#xe6a7;</i><cite>微章</cite></a></li>
                    <li><a _href="html/timeline.html"><i class="iconfont">&#xe6a7;</i><cite>时间线</cite></a></li>
                    <li><a _href="html/table-element.html"><i class="iconfont">&#xe6a7;</i><cite>静态表格</cite></a></li>
                    <li><a _href="html/anim.html"><i class="iconfont">&#xe6a7;</i><cite>动画</cite></a></li>
                </ul>
            </li>


            <li>
                <a href="javascript:;"><i class="iconfont">&#xe6f6;</i><cite>组件页面</cite><i class="iconfont nav_right">&#xe6a7;</i></a>
                <ul class="sub-menu">
                    <li><a _href="html/upload.html"><i class="iconfont">&#xe6a7;</i><cite>文件上传</cite></a></li>
                    <li><a _href="html/page.html"><i class="iconfont">&#xe6a7;</i><cite>分页</cite></a></li>
                    <li><a _href="html/cate.html"><i class="iconfont">&#xe6a7;</i><cite>多级分类</cite></a></li>
                    <li><a _href="html/carousel.html"><i class="iconfont">&#xe6a7;</i><cite>轮播图</cite></a></li>
                    <li><a _href="html/city.html"><i class="iconfont">&#xe6a7;</i><cite>城市三级联动</cite></a></li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>排版布局</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li><a _href="html/grid.html"><i class="iconfont">&#xe6a7;</i><cite>栅格</cite></a></li>
                    <li><a _href="html/welcome2.html"><i class="iconfont">&#xe6a7;</i><cite>排版</cite></a></li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe69e;</i>
                    <cite>订单管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/order-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>订单列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>管理员管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/admin-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理员列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/admin-role.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>角色管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/admin-cate.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限分类</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/admin-rule.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/member-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员列表</cite>

                        </a>
                    </li>
                    <li>
                        <a _href="html/member-del.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员删除</cite>

                        </a>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont">&#xe70b;</i>
                            <cite>会员管理</cite>
                            <i class="iconfont nav_right">&#xe6a7;</i>
                        </a>
                        <ul class="sub-menu">
                            <li>
                                <a _href="html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员列表</cite>

                                </a>
                            </li>
                            <li>
                                <a _href="html/member-del.html">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>会员删除</cite>

                                </a>
                            </li>

                        </ul>
                    </li>

                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ae;</i>
                    <cite>系统统计</cite>
                    <i class="iconfont nav_right">&#xe6a7;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="html/echarts1.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>拆线图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts2.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>柱状图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts3.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>地图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts4.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>饼图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts5.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>雷达图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts6.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>k线图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts7.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>热力图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="html/echarts8.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>仪表图</cite>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='html/welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<!--<div class="footer">
    <div class="copyright">Copyright ©2019 L-admin v2.3 All Rights Reserved</div>
</div>-->
<!-- 底部结束 -->
</body>
</html>
