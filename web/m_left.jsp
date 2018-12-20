<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="m_left">
    <div class="left_n">管理中心</div>
    <div id="left_m" class="left_m">
        <div class="left_m_t t_bg1">订单中心</div>
        <ul>
            <li><a href="Member_Order.jsp" class="now">我的订单</a></li>
            <li><a href="Member_Address.jsp">收货地址</a></li>
            <%--<li><a href="#">缺货登记</a></li>
            <li><a href="#">跟踪订单</a></li>--%>
        </ul>
    </div>
    <div class="left_m">
        <div class="left_m_t t_bg2">用户中心</div>
        <ul>
            <li><a href="Member_User.html">用户信息</a></li>
            <li><a href="Member_Collect.html">我的收藏</a></li>
            <%--<li><a href="Member_Msg.html">我的留言</a></li>
            <li><a href="Member_Links.html">推广链接</a></li>
            <li><a href="#">我的评论</a></li>--%>
        </ul>
    </div>
    <%--<div class="left_m">
        <div class="left_m_t t_bg3">账户中心</div>
        <ul>
            <li><a href="Member_Safe.html">账户安全</a></li>
            <li><a href="Member_Packet.html">我的红包</a></li>
            <li><a href="Member_Money.html">资金管理</a></li>
        </ul>
    </div>
    <div class="left_m">
        <div class="left_m_t t_bg4">分销中心</div>
        <ul>
            <li><a href="Member_Member.html">我的会员</a></li>
            <li><a href="Member_Results.html">我的业绩</a></li>
            <li><a href="Member_Commission.html">我的佣金</a></li>
            <li><a href="Member_Cash.html">申请提现</a></li>
        </ul>
    </div>--%>
</div>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
    function doClass(obj) {
        $(obj).addClass(".now");
    }
</script>
