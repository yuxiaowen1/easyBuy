<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="menu">
    <!--Begin 商品分类详情 Begin-->
    <div class="nav">
        <div class="nav_t">全部商品分类</div>
        <div class="leftNav" style="display: none;">
            <ul id="index_leftNav">
                <c:forEach var="menu1" items="${sessionScope.menu}">
                    <li>
                        <div class="fj">
                            <span class="n_img"><span></span><img src="${menu1.iconClass}" /></span>
                            <span class="fl">${menu1.name}</span>
                        </div>
                        <div class="zj">
                            <div class="zj_l">
                                <c:if test="${not empty menu1}">
                                    <c:forEach var="menu2" items="${menu1.list}">
                                        <div class="zj_l_c">
                                            <h2>${menu2.name}</h2>
                                            <c:forEach var="menu3" items="${menu2.list}">
                                                <a href="/product?opr=find&pid=${menu3.id}">${menu3.name}</a>
                                            </c:forEach>
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <ul class="menu_r" id="test_menu_r">
        <li><a href="/">首页</a></li>
        <c:forEach var="list" items="${sessionScope.menu}">
            <li><a href="/product?opr=findAllPro&pid=${list.id}">${list.name}</a></li>
        </c:forEach>
    </ul>
    <div class="m_ad">中秋送好礼！</div>
    <!--End 商品分类详情 End-->
</div>
