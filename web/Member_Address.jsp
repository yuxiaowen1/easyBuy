<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
        
    
<title>尤洪</title>
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
                    <li><a href="Member_Order.jsp">我的订单</a></li>
                    <li><a href="Member_Address.jsp" class="now">收货地址</a></li>
                </ul>
            </div>
            <div class="left_m">
                <div class="left_m_t t_bg2">用户中心</div>
                <ul>
                    <li><a href="Member_User.html">用户信息</a></li>
                    <li><a href="Member_Collect.html">我的收藏</a></li>
                </ul>
            </div>
        </div>
		<div class="m_right">
            <p></p>
            <div class="mem_tit">收货地址</div>
			<div id="member_address" class="address">

            </div>
            <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
            <script type="text/javascript">
                $(function () {
                    var json = {opr:"findByUserId"};
                    $.ajax({
                        url:"/address",
                        type:"post",
                        data:json,
                        dataType:"json",
                        success:function (data) {
                            $.each(data,function (index,obj) {
                                $("#member_address").append("<div>\n" +
                                    "                    <div class=\"a_close\"><a href=\"#\"><img src=\"images/a_close.png\" /></a></div>\n" +
                                    "                    <table border=\"0\" class=\"add_t\" align=\"center\" style=\"width:98%; margin:10px auto;\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                                    "                        <tr>\n" +
                                    "                            <td colspan=\"2\" style=\"font-size:14px; color:#ff4e00;\">"+obj.remark+"</td>\n" +
                                    "                        </tr>\n" +
                                    "                        <tr>\n" +
                                    "                            <td align=\"right\" width=\"80\">收货人：</td>\n" +
                                    "                            <td>${sessionScope.user.loginName}</td>\n" +
                                    "                        </tr>\n" +
                                    "                        <tr>\n" +
                                    "                            <td align=\"right\">配送区域：</td>\n" +
                                    "                            <td>"+obj.address+"</td>\n" +
                                    "                        </tr>\n" +
                                    "                        <tr>\n" +
                                    "                            <td align=\"right\">详细地址：</td>\n" +
                                    "                            <td>"+obj.address+"</td>\n" +
                                    "                        </tr>\n" +
                                    "                        <tr>\n" +
                                    "                            <td align=\"right\">手机：</td>\n" +
                                    "                            <td>${sessionScope.user.mobile}</td>\n" +
                                    "                        </tr>\n" +
                                    "                        <tr>\n" +
                                    "                            <td align=\"right\">电话：</td>\n" +
                                    "                            <td>${sessionScope.user.mobile}</td>\n" +
                                    "                        </tr>\n" +
                                    "                        <tr>\n" +
                                    "                            <td align=\"right\">电子邮箱：</td>\n" +
                                    "                            <td>${sessionScope.user.email}</td>\n" +
                                    "                        </tr>\n" +
                                    "                        <tr>\n" +
                                    "                            <td align=\"right\">标志建筑：</td>\n" +
                                    "                            <td>世外桃源</td>\n" +
                                    "                        </tr>\n" +
                                    "                    </table>\n" +
                                    "                    <p align=\"right\">\n" +
                                    "                        <a href=\"#\" style=\"color:#ff4e00;\">" +
                                    "<c:if test='${obj.isDefault ne 1}'>设为默认</c:if>" +
                                    "</a>&nbsp; &nbsp; &nbsp; &nbsp; <a href=\"#\" style=\"color:#ff4e00;\">编辑</a>&nbsp; &nbsp; &nbsp; &nbsp;\n" +
                                    "                    </p>\n" +
                                    "                </div>");
                            });
                        }
                    });
                });
            </script>


            <%--<div class="mem_tit">
            	<a href="#"><img src="images/add_ad.gif" /></a>
            </div>
            <table border="0" class="add_tab" style="width:930px;"  cellspacing="0" cellpadding="0">
              <tr>
                <td width="135" align="right">配送地区</td>
                <td colspan="3" style="font-family:'宋体';">
                	<select class="jj" name="country" style="background-color:#f6f6f6;">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">中国</option>
                      <option value="2">中国</option>
                      <option value="3">中国</option>
                      <option value="4">中国</option>
                    </select>
                	<select class="jj" name="province">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">四川</option>
                      <option value="2">重庆</option>
                      <option value="3">北京</option>
                      <option value="4">云南</option>
                    </select>
                    <select class="jj" name="city">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">成都</option>
                      <option value="2">宜宾</option>
                      <option value="3">南充</option>
                      <option value="4">绵阳</option>
                    </select>
                    <select class="jj" name="area">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">武侯区</option>
                      <option value="2">成华区</option>
                      <option value="3">锦江区</option>
                      <option value="4">青羊区</option>
                    </select>
                    （必填）
                </td>
              </tr>
              <tr>
                <td align="right">收货人姓名</td>
                <td style="font-family:'宋体';"><input type="text" value="姓名" class="add_ipt" />（必填）</td>
                <td align="right">电子邮箱</td>
                <td style="font-family:'宋体';"><input type="text" value="12345678@qq.com" class="add_ipt" />（必填）</td>
              </tr>
              <tr>
                <td align="right">详细地址</td>
                <td style="font-family:'宋体';"><input type="text" value="世外桃源" class="add_ipt" />（必填）</td>
                <td align="right">邮政编码</td>
                <td style="font-family:'宋体';"><input type="text" value="610000" class="add_ipt" /></td>
              </tr>
              <tr>
                <td align="right">手机</td>
                <td style="font-family:'宋体';"><input type="text" value="1361234587" class="add_ipt" />（必填）</td>
                <td align="right">电话</td>
                <td style="font-family:'宋体';"><input type="text" value="028-12345678" class="add_ipt" /></td>
              </tr>
              <tr>
                <td align="right">标志建筑</td>
                <td style="font-family:'宋体';"><input type="text" value="世外桃源大酒店" class="add_ipt" /></td>
                <td align="right">最佳送货时间</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="add_ipt" /></td>
              </tr>
            </table>
           	<p align="right">
            	<a href="#">删除</a>&nbsp; &nbsp; <a href="#" class="add_b">确认修改</a>
            </p> --%>
           

            
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
