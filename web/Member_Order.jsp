<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>
    <script type="text/javascript" src="js/select.js"></script>
    <script type="text/javascript" src="js/lrscroll.js"></script>
    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>

    <script type="text/javascript" src="js/lrscroll_1.js"></script>


<title>易购网</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <%@include file="address.jsp"%>
</div>
<div class="m_top_bg">
    <div id="searchBar">
        <%@include file="top.jsp"%>
    </div>
</div>
<!--End Header End-->
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
        <div class="m_left">
            <div class="left_n">管理中心</div>
            <div id="left_m" class="left_m">
                <div class="left_m_t t_bg1">订单中心</div>
                <ul>
                    <li><a href="Member_Order.jsp" class="now">我的订单</a></li>
                    <%--<li><a href="Member_Address.jsp">收货地址</a></li>--%>
                    <%--<li><a href="#">缺货登记</a></li>
                    <li><a href="#">跟踪订单</a></li>--%>
                </ul>
            </div>
            <div class="left_m">
                <div class="left_m_t t_bg2">用户中心</div>
                <ul>
                    <li><a href="Member_User.html">用户信息</a></li>
                    <%--<li><a href="Member_Collect.html">我的收藏</a></li>--%>
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
		<div class="m_right">
            <p></p>
            <div class="mem_tit">我的订单</div>
            <table id="member_order_info" border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="20%">订单号</td>
                <td width="25%">下单时间</td>
                <td width="15%">订单总金额</td>
                <td width="25%">订单状态</td>
                <td width="15%">操作</td>
              </tr>
            </table>
            <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
            <script type="text/javascript">
                $(function () {
                    var json = {opr:"findByUserId"};
                    $.ajax({
                        url:"/order",
                        type:"post",
                        data:json,
                        dataType:"json",
                        success:function (data) {
                            $.each(data,function (index,obj) {
                                $("#member_order_info").append("<tr>\n" +
                                    "                <td><font color=\"#ff4e00\">"+obj.serialNumber+"</font></td>\n" +
                                    "                <td>"+new Date(obj.createTime).toLocaleString()+"</td>\n" +
                                    "                <td>￥"+obj.cost+"</td>\n" +
                                    "                <td>未确认，未付款，未发货</td>\n" +
                                    "                <td>已确认</td>\n" +
                                    "              </tr>")
                            });
                        }
                    });
                });
            </script>

                <%--<div class="mem_tit">合并订单</div>
                <table border="0" class="order_tab" style="width:930px;"  cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="135" align="right">主订单</td>
                    <td width="220">
                        <select class="jj" name="order1">
                          <option value="0" selected="selected">请选择...</option>
                          <option value="1">2015092626589</option>
                          <option value="2">2015092626589</option>
                          <option value="3">2015092626589</option>
                          <option value="4">2015092626589</option>
                        </select>
                    </td>
                    <td width="135" align="right">从订单</td>
                    <td width="220">
                        <select class="jj" name="order2">
                          <option value="0" selected="selected">请选择...</option>
                          <option value="1">2015092626589</option>
                          <option value="2">2015092626589</option>
                          <option value="3">2015092626589</option>
                          <option value="4">2015092626589</option>
                        </select>
                    </td>
                    <td><div class="btn_u"><a href="#">合并订单</a></div></td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td colspan="4" style="font-family:'宋体'; padding:20px 10px 50px 10px;">
                        订单合并是在发货前将相同状态的订单合并成一新的订单。 <br />
                        收货地址，送货方式等以主定单为准。
                    </td>
                  </tr>
                </table>--%>

            
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <%@include file="bottom.jsp"%>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
