package cn.bdqn.servlet;

import cn.bdqn.entity.News;
import cn.bdqn.service.NewsService;
import cn.bdqn.service.impl.NewsServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import sun.plugin2.message.JavaScriptBaseMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/news"})
public class NewsServlet extends HttpServlet {

    private NewsService service;

    @Override
    public void init() throws ServletException {
        service = new NewsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
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
        }
    }

    private void doFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<News> allNews = service.findAll();
        out.print(JSON.toJSONString(allNews, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNonStringKeyAsString));
        out.flush();
        out.close();
    }
}
