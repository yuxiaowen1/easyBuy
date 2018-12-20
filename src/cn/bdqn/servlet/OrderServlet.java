package cn.bdqn.servlet;

import cn.bdqn.dao.OrderDao;
import cn.bdqn.entity.*;
import cn.bdqn.service.OrderService;
import cn.bdqn.service.impl.AddressServiceImpl;
import cn.bdqn.service.impl.OrderDetailServiceImpl;
import cn.bdqn.service.impl.OrderServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {
    private OrderService service;

    @Override
    public void init() throws ServletException {
        service = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opr = req.getParameter("opr");
        System.out.println(opr);
        switch (opr){
            case "addOrder":
                addOrder(req,resp);
                break;
            case "findByUserId":
                findByUserId(req,resp);
                break;
            case "findOrderByUserId":
                findOrderByUserId(req,resp);
                break;
        }
    }

    private void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String address = req.getParameter("address");
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user+"---addOrder--user");
        float cost = Float.parseFloat(req.getParameter("cost"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int rannum = (int) ((random.nextDouble() * (99999 - 10000 + 1)) + 10000);// 获取5位随机数
        System.out.println(rannum+str);
        int add = service.add(new Order(user.getId(), user.getLoginName(), address, new Date(), cost, rannum+str));
        out.print(add);
        out.flush();
        out.close();
    }

    private void findOrderByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        Address address = new AddressServiceImpl().findByIsDefault(user.getId());
        Order order = service.findByUserIdAndAddress(user.getId(), address.getAddress());
        HashMap<Product,Integer> cars= (HashMap<Product, Integer>) req.getSession().getAttribute("car");
        Set<Product> products = cars.keySet();
        for (Product product:products){
            Integer integer = cars.get(product);
            OrderDetail orderDetail = new OrderDetail(order.getId(),product.getId(),integer,product.getPrice() * integer);
            new OrderDetailServiceImpl().add(orderDetail);
        }
        System.out.println(address);
        out.print(JSON.toJSONString(address, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNonStringKeyAsString));
        out.flush();
        out.close();
    }

    private void findByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orders = service.findByUserId(user.getId());
        System.out.println(orders);
        out.print(JSON.toJSONString(orders,SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNonStringKeyAsString));
        out.flush();
        out.close();
    }

}
