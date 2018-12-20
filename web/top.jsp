<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="top">
    <div class="logo"><a href="/"><img src="images/logo.png" /></a></div>
    <div class="search">
        <form action="/product" method="post">
            <input type="hidden" name="opr" value="findByName" />
            <input type="text" name="proName" value="${param.proName}" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn" />
        </form>
        <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
    </div>
    <div class="i_car">
        <div class="car_t">
            购物车 [ <span name="carNum">
            <c:if test="${sessionScope.car.size() eq 0}">
                空
            </c:if>
            <c:if test="${sessionScope.car eq null}">
                空
            </c:if>
            <c:if test="${sessionScope.car.size() ne 0}">
                ${sessionScope.car.size()}
            </c:if>
        </span> ]
        </div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            <c:if test="${sessionScope.user eq null}">
                <div class="un_login">还未登录！<a href="Login.jsp" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
            </c:if>
            <div id="kong" style="display: block" class="un_login">当前购物车空空如也！</div>
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->

            <ul class="cars" id="car_ul">

            </ul>

            <div id="showTotal" style="display: none" class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span name="car_count_price"></span></div>
            <c:if test="${not empty sessionScope.user}">
                <div class="price_a" id="toPay" style="display: none"><a href="buyCar.jsp">去购物车结算</a></div>
            </c:if>
            <c:if test="${sessionScope.user eq null}">
                <div class="price_a" id="toPay" style="display: none"><a href="Login.jsp">马上登录</a></div>
            </c:if>
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
    function addCartByParam(proId,num) {
        $.ajax({
            url:"/product",
            type:"post",
            data:{opr:"addCar",proId:proId,num:num},
            dataType:"json",
            success:function (data) {
                if (proId != undefined){
                    ShowDiv_1('MyDiv1','fade1')
                    $("#MyDiv1").show();
                }
                $("#car_ul").html("");
                var total = 0;
                var proNum = 0;
                $.each(data,function (index,obj) {
                    $("#car_ul").append("<li>\n" +
                        "                            <div class=\"img\"><a href=\"#\"><img src=\"images/"+obj.filename+"\" width=\"58\" height=\"58\" /></a></div>\n" +
                        "                            <div class=\"name\"><a href=\"#\">"+obj.product.name+"</a></div>\n" +
                        "                            <div class=\"price\"><font color=\"#ff4e00\">￥"+obj.product.price+"</font> X"+obj.num+"</div>\n" +
                        "                        </li>");
                    proNum = proNum + obj.num;
                    $("[name=carNum]").html(index+1);
                    total = obj.num * obj.product.price + total;
                    if (obj.num>0){
                        $("#toPay").show();
                        $("#showTotal").show();
                        $("#kong").hide();
                    }
                });
                $("[name=car_count_price]").html(total);
                $("[name=car_count_price_all]").html(total+15);
                $("[name=proNum]").html(proNum);
            }
        });
    };
    $(function () {
        addCartByParam();
    });
</script>
