package cn.bdqn.servlet;

import cn.bdqn.entity.Address;
import cn.bdqn.entity.User;
import cn.bdqn.service.AddressService;
import cn.bdqn.service.impl.AddressServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/address"})
public class AddressServlet extends HttpServlet {

    private AddressService service;

    @Override
    public void init() throws ServletException {
        service = new AddressServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opr = req.getParameter("opr");
        System.out.println(opr+"----AddressServlet");
        switch (opr){
            case "findByUserId":
                doFindByUserId(req,resp);
                break;
            case "addAddress":
                doAddAddress(req,resp);
                break;
        }
    }

    private void doFindByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user.getId()+"----doFindByUserId----"+user);
        List<Address> addresses = service.getAllByUserId(user.getId());
        out.write(JSON.toJSONString(addresses, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNonStringKeyAsString));
        out.flush();
        out.close();
    }

    private void doAddAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String address = req.getParameter("address");
        String remake = req.getParameter("remake");
        User user = (User) req.getSession().getAttribute("user");
        Address address1 = new Address(user.getId(),address,new Date(),1,remake);
        int add = service.add(address1);
        out.print(add);
        out.flush();
        out.close();
    }
}
