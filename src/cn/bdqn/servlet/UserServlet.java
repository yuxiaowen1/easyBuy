package cn.bdqn.servlet;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/userServlet"})
public class UserServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opr = req.getParameter("opr");
        System.out.println(opr);
        switch (opr){
            case "register":
                doRegister(req,resp);
                break;
            case "find":
                doFind(req,resp);
                break;
            case "login":
                doLogin(req,resp);
                break;
            case "destroy":
                doDestroy(req,resp);
                break;
        }
    }

    /**
     * 执行注册功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String loginName = req.getParameter("loginName");
        String identityCode = req.getParameter("identityCode");
        User user = new User(loginName,username,password,identityCode,email,mobile);
        int result = service.add(user);
        if (result > 0){
            out.print(result);
        }
        out.flush();
        out.close();
    }

    /**
     * 执行登录操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        List<User> users = service.findAll();
        String str = "";
        for (User user:users){
            if (username.equals(user.getUserName())&&password.equals(user.getPassword())){
                req.getSession().setAttribute("user",user);
                System.out.println(user+"login");
                str = "success";
            }
        }
        if ("".equals(str)){
            str = "error";
        }
        out.print(str);
        out.flush();
        out.close();
    }

    /**
     * 查找所有用户信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doFind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        List<User> users = service.findAll();
        String str = "success";
        for (User user:users){
            if (user.getUserName().equals(username)){
                str = "error";
            }
        }
        String json = JSON.toJSONString(users, SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNonStringKeyAsString);
        //out.print(json);
        out.print(str);
        out.flush();
        out.close();
    }


    private void doDestroy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().removeAttribute("user");
        resp.sendRedirect("/");
    }
}
