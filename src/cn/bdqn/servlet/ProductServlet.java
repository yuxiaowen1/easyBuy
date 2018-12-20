package cn.bdqn.servlet;

import cn.bdqn.entity.BuyCar;
import cn.bdqn.entity.ProCategory;
import cn.bdqn.entity.Product;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.impl.ProCategoryServiceImpl;
import cn.bdqn.service.impl.ProductServiceImpl;
import cn.bdqn.utils.PageBean;
import cn.bdqn.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 商品类控制器
 */
@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {

    private ProductService service;

    @Override
    public void init() throws ServletException {
        service = new ProductServiceImpl();
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
            case "find":
                doFindProduct(req,resp);
                break;
            case "findAllPro":
                findAllPro(req,resp);
                break;
            case "addCar":
                addCar(req,resp);
                break;
            case "show":
                doShow(req,resp);
                break;
            case "delCarProById":
                delCarProById(req,resp);
                break;
            case "findByName":
                findByName(req,resp);
                break;
        }
    }

    /**
     * 通过父类菜单id查询子类菜单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProCategory> categories = (List<ProCategory>) req.getAttribute("categories");
        for (ProCategory proCategory:categories){
            proCategory.setProducts(service.findByCategoryLevel1Id(proCategory.getId()));
        }
        req.getSession().setAttribute("menu",categories);
        resp.sendRedirect("index.jsp");
    }

    /**
     * 通过商品id删除购物车中的商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void delCarProById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proId = req.getParameter("proId");
        System.out.println(Integer.parseInt(proId)+"---proId---delCarProById");
        HashMap<Product,Integer> cars = (HashMap<Product, Integer>) req.getSession().getAttribute("car");
        for (Product product:cars.keySet()){
            if (product.getId() == Integer.parseInt(proId)){
                cars.remove(product);
            }
        }
        resp.sendRedirect("buyCar.jsp");
    }

    /**
     * 分页查询所有三级菜单类型的商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doFindProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        PageBean<Product> productPageBean = service.findByCategoryLevel3Id(Integer.parseInt(pid), StringUtils.String2Int(pageIndex, 1), StringUtils.String2Int(pageSize, 8));
        req.setAttribute("products",productPageBean);
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }

    /**
     * 分页查询所有一级类型的商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void findAllPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        PageBean<Product> productPageBean = service.findByCategoryLevel1Id(Integer.parseInt(pid), StringUtils.String2Int(pageIndex, 1), StringUtils.String2Int(pageSize, 8));
        req.setAttribute("products",productPageBean);
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }

    /**
     * 展示商品详情信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void doShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proId = req.getParameter("proId");
        System.out.println(proId+"-----doShow--proId");
        Product product = service.findById(Integer.parseInt(proId));
        req.setAttribute("product",product);
        req.getRequestDispatcher("pro_details.jsp").forward(req,resp);
    }

    private void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proName = req.getParameter("proName");
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        PageBean<Product> productPageBean = service.findByProName(proName, StringUtils.String2Int(pageIndex, 1), StringUtils.String2Int(pageSize, 8));
        req.setAttribute("products",productPageBean);
        req.setAttribute("proName",proName);
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }

    /**
     * 更新购物车信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        if (req.getSession().getAttribute("car") == null){
            HashMap<Product,Integer> cars = new HashMap<>();
            req.getSession().setAttribute("car",cars);
        }
        HashMap<Product,Integer> cars= (HashMap<Product, Integer>) req.getSession().getAttribute("car");
        String id = req.getParameter("proId");
        String num = req.getParameter("num");
        System.out.println(num+"addCar--num");
        if (id != null){
            Product product = service.findById(StringUtils.String2Int(id, 0));
            if (cars.containsKey(product)){
                cars.put(product,cars.get(product)+StringUtils.String2Int(num,1));
            }else {
                cars.put(product,StringUtils.String2Int(num,1));
            }
        }
        List<BuyCar> buyCars = new ArrayList<>();
        Set<Product> products = cars.keySet();
        for (Product product1:products){
            BuyCar buyCar = new BuyCar(product1,cars.get(product1));
            buyCars.add(buyCar);
        }
        out.print(JSON.toJSONString(buyCars));
        out.flush();
        out.close();

    }
}
