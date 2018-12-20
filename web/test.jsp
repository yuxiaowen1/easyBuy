<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <div class="soubg">
        <%@include file="address.jsp"%>
    </div>
    <div id="fade1" class="black_overlay"></div>
    <div id="MyDiv1" class="white_content">
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="images/close.gif" /></span>
            </div>
            <div class="notice_c">
                <table border="0" align="center" cellspacing="0" cellpadding="0">
                    <tr valign="top">
                        <td width="40"><img src="images/suc.png"></td>
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
    <script type="text/javascript" src="js/MagicZoom.js"></script>
    <script type="text/javascript" src="js/num.js"></script>
    <script type="text/javascript" src="js/p_tab.js"></script>
    <script type="text/javascript" src="js/shade.js"></script>
    <script type="text/javascript" src="js/n_nav.js"></script>
    <title>易买网</title>
</head>
<body>
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
    <!--Begin 筛选条件 Begin-->
    <!--End 筛选条件 End-->
    <div class="content mar_20">
        <div id="favoriteList">
            <div class="l_history">
                <div class="fav_t">我的收藏</div>
            </div>
        </div>
        <div class="l_list">
            <div class="list_t">
                <span class="fr">共发现${products.totalCount}件</span>
            </div>
            <c:if test="${products.list eq null}">
                <h3 style="text-align: center;">该类别商品正在努力上架...</h3>
            </c:if>
            <c:if test="${not empty products.list}">
                <div class="list_c">
                <ul class="cate_list">
                        <c:forEach items="${products.list}" var="products">
                            <li>
                                <div class="img">
                                    <a href="/product?opr=show&proId=${products.id}" target="_blank">
                                        <img src="images/${products.fileName}" width="210" height="185"/>
                                    </a>
                                </div>
                                <div class="price">
                                    <font>￥<span>${products.price}</span></font>
                                </div>
                                <div class="name"><a href="/product?opr=show&proId=${products.id}">${products.name}</a></div>
                                <div class="carbg">
                                    <a href="javascript:void(0);" class="ss" onclick="addFavorite(${products.id})">收藏</a>
                                    <a href="javascript:void(0);" class="j_car" onclick="addCartByParam(${products.id},1);">加入购物车</a>
                                </div>
                            </li>
                        </c:forEach>
                </ul>
                <div class="pages">
                    <a onclick="turn(1);" href="javascript:void(0);" class="p_pre">首页</a>
                    <c:forEach begin="1" end="${products.pageCount}" step="1" varStatus="status">
                        <a onclick="turn(${status.index});" href="javascript:void(0);" <c:if test="${products.pageIndex eq status.index}"> class="cur" </c:if> >${status.index}</a>
                    </c:forEach>
                    <a onclick="turn(${products.pageCount});" href="javascript:void(0);" class="p_pre">尾页</a>
                </div>
            </div>
            </c:if>
        </div>
    </div>
    <%@include file="bottom.jsp"%>
</div>
<form id="turnFrm" method="post" action="product">
    <c:if test="${not empty products.list}">
        <input type="text" name="opr" value="find" />
        <input type="text" id="pageIndex" name="pageIndex" value="" />
        <input type="text" name="pid" value="${products.list.get(0).categoryLevel3Id}" />
    </c:if>
    <c:if test="${products.list eq null}">
        <input type="text" name="opr" value="findByName" />
        <input type="text" id="pageIndex" name="pageIndex" value="" />
        <input type="text" name="proName" value="${proName}" />
    </c:if>
</form>
<script type="text/javascript">
    function turn(pageIndex){
        $("#pageIndex").val(pageIndex);
        $("#turnFrm").submit();
    }


</script>
</body>
</html>
