<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!--页面圆角开始-->
<div class="lt"></div>
<div class="rt"></div>
<div class="lb"></div>
<div class="rb"></div>
<!--页面圆角结束-->

<!--头部开始-->
<div class="header">
	<span class="l"><img src="../images/headerleft.gif" alt="CRM管理系统"/></span>
	<div class="header_content"><a href="/" title="首页"><img src="../images/sy.gif" /></a><a href="javascript:void(0);" onclick="javascript:history.go(-1);" title="后退"><img src="../images/ht.gif" /></a><a href="login!exit.do" title="退出"><img src="../images/tc.gif" /></a><span class="a"><img src="../images/8a_line.gif" /></span><a href="user!info.do" title="个人资料修改"><img src="../images/zlxg.gif" /></a><a href="user!pwd.do" title="密码修改"><img src="../images/mmxg.gif" /></a>
    </div>
    <div class="data">■ 今天是：${curdate}</div>
	<span class="r"><img src="../images/headerright.gif" /></span>
</div>
<!--头部结束-->

<!--菜单开始-->
<div class="nav">
    <div class="curr_user">当前用户：${loginUserName}</div>
    <div class="menu"></div>
	<div class="r"></div>
</div>
<!--菜单结束-->