package cn.bdqn.servlet;

import cn.bdqn.entity.News;
import cn.bdqn.entity.ProCategory;
import cn.bdqn.service.ProCategoryService;
import cn.bdqn.service.impl.NewsServiceImpl;
import cn.bdqn.service.impl.ProCategoryServiceImpl;
import cn.bdqn.service.impl.ProductServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/proCategoryServlet"})
public class ProCategoryServlet extends HttpServlet {

    private ProCategoryService service;

    @Override
    public void init() throws ServletException {
        service = new ProCategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opr = req.getParameter("opr");
        System.out.println(opr);
        if (opr==null){
            opr = "findAll";
        }
        System.out.println(opr);
        switch (opr){
            case "findAll":
                doFindAll(req,resp);
                break;
            case "find":
                doFind(req,resp);
                break;
        }
    }

    private void doFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProCategory> categories = service.getAll();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/product").forward(req,resp);
    }

    private void doFind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProCategory> categories = service.getAll();
        String string = JSON.toJSONString(categories, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNonStringKeyAsString);
        PrintWriter out = resp.getWriter();
        out.print(string);
        out.flush();
        out.close();
    }

}
