<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript">
        var contextPath = "/EasyBuy";
    </script>
    <div class="soubg">
        <%@include file="address.jsp"%>
    </div>
    <div id="fade1" class="black_overlay"></div>
    <div id="MyDiv1" class="white_content">
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="/EasyBuy/statics/images/close.gif" /></span>
            </div>
            <div class="notice_c">
                <table border="0" align="center" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="40"><img src="/EasyBuy/statics/images/suc.png"></td>
                        <td>
                            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;" id="showMessage">操作成功</span><br />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
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
    <link rel="stylesheet" type="text/css" href="css/ShopShow.css" />
    <link rel="stylesheet" type="text/css" href="css/MagicZoom.css" />
    <script type="text/javascript" src="/js/MagicZoom.js"></script>
    <script type="text/javascript" src="/js/num.js"></script>
    <script type="text/javascript" src="/js/p_tab.js"></script>
    <script type="text/javascript" src="/js/shade.js"></script>
</head>
<body>



<script type="text/javascript">
    var contextPath = "/EasyBuy";
</script>
<div id="searchBar">
    <%@include file="top.jsp"%>
</div>

<!--End Header End-->
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
    <div class="m_content">
        <div class="m_left">
            <div class="left_n">管理中心</div>
            <div class="left_m">
                <div class="left_m_t t_bg1">订单中心</div>
                <ul>
                    <li><a href="/EasyBuy/admin/order?action=index&userId=24"  class="now" >我的订单</a></li>

                </ul>
            </div>
            <div class="left_m">
                <div class="left_m_t t_bg2">会员中心</div>
                <ul>
                    <li><a href="Member_User.html"  >用户信息</a></li>

                </ul>
            </div>

            <div class="left_m">
                <div class="left_m_t t_bg2">资讯中心</div>
                <ul>
                    <li><a href="/EasyBuy/admin/news?action=queryNewsList"  >资讯列表</a></li>
                </ul>
            </div>
        </div>
        <div class="m_right" id="content">
            <p></p>
            <p></p>
            <div class="mem_tit">订单列表</div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
                <tbody>

                <tr class="td_bg">
                    <td>用户名:yxw</td>
                    <td><a href="/EasyBuy/admin/order?action=queryOrderDeatil&orderId=21">订单号:96B0A474F45244C38E914275A47E941F</a></td>
                    <td>地址:ffll</td>
                    <td>￥5866.0</td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <td colspan="4">
                        <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td width="20%">商品名称</td>
                                <td width="20%">商品图片</td>
                                <td width="25%">数量</td>
                                <td width="25%">价格</td>
                            </tr>

                            <tr>
                                <td>日本进口马桶</td>
                                <td>
                                    <a href="" target="_blank">
                                        <img src="" width="50" height="50">
                                    </a>
                                </td>
                                <td>1</td>
                                <td>5866.0</td>
                            </tr>

                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
            <script type="text/javascript">
                var contextPath = "/EasyBuy";
            </script>
            <div class="pages">
                <a href="" class="p_pre">首页</a>
                <a href="" class="cur">1</a>
                <a href="" class="p_pre">尾页</a>
            </div>

        </div>
    </div>

    <div class="b_btm_bg b_btm_c" id="footer">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="/EasyBuy/statics/images/b1.png" width="62" height="62" /></td>
                    <td><h2>正品保障</h2>正品行货  放心购买</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="/EasyBuy/statics/images/b2.png" width="62" height="62" /></td>
                    <td><h2>满38包邮</h2>满38包邮 免运费</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="/EasyBuy/statics/images/b3.png" width="62" height="62" /></td>
                    <td><h2>天天低价</h2>天天低价 畅选无忧</td>
                </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="72"><img src="/EasyBuy/statics/images/b4.png" width="62" height="62" /></td>
                    <td><h2>准时送达</h2>收货时间由你做主</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
        <dl>
            <dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
            <dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
            <dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保证</a></dd>
            <dd><a href="#">产品质量保证</a></dd>
        </dl>
        <dl>
            <dt><a href="#">联系我们</a></dt>
            <dd><a href="#">网站故障报告</a></dd>
            <dd><a href="#">购物咨询</a></dd>
            <dd><a href="#">投诉与建议</a></dd>
        </dl>
        <div class="b_tel_bg">
            <a href="#" class="b_sh1">新浪微博</a>
            <a href="#" class="b_sh2">腾讯微博</a>
            <p>
                服务热线：<br />
                <span>400-123-4567</span>
            </p>
        </div>
        <div class="b_er">
            <div class="b_er_c"><img src="/EasyBuy/statics/images/er.gif" width="118" height="118" /></div>
            <img src="/EasyBuy/statics/images/ss.png" />
        </div>
    </div>
    <div class="btmbg">
        <div class="btm">
            备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img src="/EasyBuy/statics/images/b_1.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_2.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_3.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_4.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_5.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_6.gif" width="98" height="33" />
        </div>
    </div>

</div>
</body>
</html>


