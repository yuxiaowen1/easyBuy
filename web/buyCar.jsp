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

    <script type="text/javascript" src="js/n_nav.js"></script>

    <script type="text/javascript" src="js/num.js"></script>

    <script type="text/javascript" src="js/shade.js"></script>

    <title>易购网</title>
</head>
<body>
<div class="soubg">
    <%@include file="address.jsp"%>
</div>
<!--Begin Header Begin-->
<div id="searchBar">
    <%@include file="top.jsp"%>
</div>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <%@include file="menu.jsp"%>
</div>
<!--End Menu End-->
<div class="i_bg">
    <div class="content mar_20">
        <img src="images/img1.jpg" />
    </div>

    <!--Begin 第一步：查看购物车 Begin -->
    <div class="content mar_20">
        <table id="carTable" border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
            <tr>
                <td class="car_th" width="490">商品名称</td>
                <td class="car_th" width="140">属性</td>
                <td class="car_th" width="150">购买数量</td>
                <td class="car_th" width="130">小计</td>
                <td class="car_th" width="140">返还积分</td>
                <td class="car_th" width="150">操作</td>
            </tr>
            <c:if test="${not empty sessionScope.car}">
                <c:forEach items="${sessionScope.car}" var="car" varStatus="status">
                    <tr <c:if test="${(status.index)%2 ne 0}"> class="car_tr" </c:if> >
                        <td>
                            <div class="c_s_img"><img src="images/${car.getKey().fileName}" width="73" height="73" /></div>
                                ${car.getKey().description}
                        </td>
                        <td align="center">颜色：灰色</td>
                        <td align="center">
                            <div class="c_num">
                                <input type="button" value="" onclick="del(this,${car.getKey().price},${status.index},${car.getKey().id});" class="car_btn_1" />
                                <input type="text" value="${car.getValue()}" name="count_num" class="car_ipt" />
                                <input type="button" value="" onclick="add(this,${car.getKey().price},${status.index},${car.getKey().id});" class="car_btn_2" />
                            </div>
                        </td>
                        <td align="center" style="color:#ff4e00;">￥<span name="subtotal">${car.getKey().price * car.getValue()}</span></td>
                        <td align="center">26R</td>
                        <td align="center"><a onclick="doDel(${car.getKey().id});">删除</a>&nbsp; &nbsp;<a href="#">收藏</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            <%--class="car_tr"--%>
            <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
            <script type="text/javascript">

                function doDel(proId) {
                    $("#car_proId").val(proId);
                    showDiv('MyDiv','fade');
                }
                function delCarProById() {
                    $(location).attr('href', '/product?opr=delCarProById&proId='+$("#car_proId").val());
                }
                function showDiv(show_div,bg_div){
                    document.getElementById(show_div).style.display='block';
                    document.getElementById(bg_div).style.display='block' ;
                    var bgdiv = document.getElementById(bg_div);
                    bgdiv.style.width = document.body.scrollWidth;
                    // bgdiv.style.height = $(document).height();
                    $("#"+bg_div).height($(document).height());
                };


                function del(obj,price,index,id) {
                    if ($(obj).next().val() <= 1) {
                        $(obj).next().val(1);
                    } else {
                        $(obj).next().val(parseInt($(obj).next().val()) - 1);
                        $("#carTable tr:eq("+(index+1)+")").find("span[name=subtotal]").html(price * $(obj).next().val());
                        cel(id,-1);
                    }
                }
                function add(obj,price,index,id) {
                    $(obj).prev().val(parseInt($(obj).prev().val()) + 1);
                    $("#carTable tr:eq("+(index+1)+")").find("span[name=subtotal]").html(price * $(obj).prev().val());
                    //$("span[name=subtotal]:nth-of-type(" + (index + 1) + ")").html(price * $(obj).prev().val());
                    cel(id,1);
                }

                function cel(id,num) {
                    $.ajax({
                        url:"/product",
                        type:"post",
                        data:{opr:"addCar",proId:id,num:num},
                        dataType:"json",
                        success:function (data) {
                            var total = 0;
                            $.each(data,function (index,obj) {
                                total = obj.num * obj.product.price + total;
                            });
                            $("[name=car_count_price]").html(total);
                        }
                    });
                }
            </script>

            <tr height="70">
                <td colspan="6" style="font-family:'Microsoft YaHei'; border-bottom:0;">
                    <label class="r_rad"><input type="checkbox" name="clear" checked="checked" /></label><label class="r_txt">清空购物车</label>
                    <span class="fr">商品总价：￥<b name="car_count_price" style="font-size:22px; color:#ff4e00;"></b></span>
                </td>
            </tr>
            <tr valign="top" height="150">
                <td colspan="6" align="right">
                    <a href="/"><img src="images/buy1.gif" /></a>&nbsp; &nbsp; <a href="BuyCar_Two.jsp"><img src="images/buy2.gif" /></a>
                </td>
            </tr>
        </table>

    </div>
    <!--End 第一步：查看购物车 End-->


    <!--Begin 弹出层-删除商品 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img src="images/close.gif" /></span>
            </div>
            <div class="notice_c">

                <table border="0" align="center" style="font-size:16px;" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td>您确定要把该商品移除购物车吗？</td>
                    </tr>
                    <tr height="50" valign="bottom">
                        <input type="hidden" id="car_proId" value="" />
                        <td><a href="javascript:delCarProById();" class="b_sure">确定</a><a href="#" class="b_buy">取消</a></td>
                    </tr>
                </table>

            </div>
        </div>
    </div>
    <!--End 弹出层-删除商品 End-->


    <!--Begin Footer Begin -->
    <%@include file="bottom.jsp"%>
    <!--End Footer End -->
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
