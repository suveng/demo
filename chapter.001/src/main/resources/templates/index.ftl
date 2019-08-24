<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台</title>

    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <#--样式-->
    <link rel="stylesheet" href="${request.contextPath}/campus/static/css/font.css">
    <link rel="stylesheet" href="${request.contextPath}/campus/static/css/xadmin.css">

    <#--脚本-->
    <script src="${request.contextPath}/campus/static/js/jquery.min.js"></script>

    <script src="${request.contextPath}/campus/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${request.contextPath}/campus/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="${request.contextPath}/campus/static/js/html5.min.js"></script>
    <script src="${request.contextPath}/campus/static/js/respond.min.js"></script>
    <![endif]-->

    <script>
        // 是否开启刷新记忆tab功能
        // var is_remember = false;
    </script>
</head>
<body class="index">
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="">后台</a></div>
    <div class="left_open">
        <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
    </div>


    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child">
                <!-- 二级菜单 -->
                <dd>
                    <a onclick="xadmin.open('个人信息','http://www.baidu.com')">个人信息</a></dd>
                <dd>
                    <a onclick="xadmin.open('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                <dd>
                    <a href="">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index">
            <a href="/campus">回到首页</a></li>
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
                    <i class="iconfont left-nav-li" lay-tips="校园招聘">&#xe6b4;</i>
                    <cite>校园招聘</cite>
                    <i class="iconfont nav_right">&#xe697;</i></a>
                <ul class="sub-menu">
                    <li>
                        <a onclick="xadmin.add_tab('网申','/campus/apply_list.html')" target="">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>网申</cite></a>
                    </li>
                    <li>
                        <a onclick="xadmin.add_tab('助力活动','/campus/assistance_activity.html')">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>助力活动</cite></a>
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
            <li class="home">
                <i class="layui-icon">&#xe68e;</i>我的桌面
            </li>
        </ul>
        <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
            <dl>
                <dd data-type="this">关闭当前</dd>
                <dd data-type="other">关闭其它</dd>
                <dd data-type="all">关闭全部</dd>
            </dl>
        </div>

        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show0">
                <iframe src='/campus/welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>

        <div id="tab_show"></div>
    </div>
</div>
<div class="page-content-bg"></div>
<style id="theme_style"></style>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
</body>
</html>
<#--<script src="${request.contextPath}/campus/system/js/index.js"></script>-->
