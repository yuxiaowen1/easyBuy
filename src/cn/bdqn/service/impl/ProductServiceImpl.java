package cn.bdqn.service.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.ProductDao;
import cn.bdqn.dao.impl.ProductDaoImpl;
import cn.bdqn.entity.Product;
import cn.bdqn.service.ProductService;
import cn.bdqn.utils.PageBean;

import java.sql.Connection;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao dao;

    @Override
    public int add(Product product) {
        return 0;
    }

    @Override
    public int delById(int id) {
        return 0;
    }

    @Override
    public int upDate(Product product) {
        return 0;
    }

    @Override
    public Product findById(int id) {
        Connection connection = BaseDao.getConnection();
        dao = new ProductDaoImpl();
        Product product = dao.getById(id, connection);
        BaseDao.closeResource(connection,null,null,null);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Connection connection = BaseDao.getConnection();
        dao = new ProductDaoImpl();
        List<Product> productList = dao.getAll(connection);
        BaseDao.closeResource(connection,null,null,null);
        return productList;
    }

    @Override
    public PageBean<Product> findByCategoryLevel1Id(int categoryLevel1Id,int pageIndex,int pageSize) {
        Connection connection = BaseDao.getConnection();
        dao = new ProductDaoImpl();
        PageBean<Product> productPageBean = new PageBean<>();
        int totalCount = dao.getCountByCategoryLevel1Id(categoryLevel1Id,connection);
        productPageBean.setTotalCount(totalCount);
        productPageBean.setPageSize(pageSize);
        productPageBean.setPageIndex(pageIndex);
        if (totalCount > 0){
            List<Product> productList = dao.getByCategoryLevel1Id(categoryLevel1Id,(pageIndex-1)*pageSize,pageSize, connection);
            productPageBean.setList(productList);
        }
        BaseDao.closeResource(connection,null,null,null);
        return productPageBean;
    }

    @Override
    public List<Product> findByCategoryLevel1Id(int categoryLevel1Id) {
        Connection connection = BaseDao.getConnection();
        dao = new ProductDaoImpl();
        List<Product> productList = dao.getByCategoryLevel1Id(categoryLevel1Id, connection);
        BaseDao.closeResource(connection,null,null,null);
        return productList;
    }

    @Override
    public PageBean<Product> findByCategoryLevel3Id(int categoryLevel3Id,int pageIndex,int pageSize) {
        Connection connection = BaseDao.getConnection();
        dao = new ProductDaoImpl();
        PageBean<Product> productPageBean = new PageBean<>();
        int totalCount = dao.getCountByCategoryLevel3Id(categoryLevel3Id,connection);
        if (totalCount > 0){
            productPageBean.setTotalCount(totalCount);
            productPageBean.setPageSize(pageSize);
            productPageBean.setPageIndex(pageIndex);
            List<Product> productList = dao.getByCategoryLevel3Id(categoryLevel3Id,(pageIndex-1)*pageSize,pageSize, connection);
            productPageBean.setList(productList);
        }
        BaseDao.closeResource(connection,null,null,null);
        return productPageBean;
    }

    @Override
    public List<Product> findByCategoryLevel3Id(int categoryLevel3Id) {
        Connection connection = BaseDao.getConnection();
        dao = new ProductDaoImpl();
        List<Product> productList = dao.getByCategoryLevel3Id(categoryLevel3Id, connection);
        BaseDao.closeResource(connection,null,null,null);
        return productList;
    }

    @Override
    public PageBean<Product> findByProName(String proName, int pageIndex, int pageSize) {
        Connection connection = BaseDao.getConnection();
        dao = new ProductDaoImpl();
        PageBean<Product> productPageBean = new PageBean<>();
        int totalCount = dao.getCountByProName(proName,connection);
        if (totalCount > 0){
            productPageBean.setTotalCount(totalCount);
            productPageBean.setPageSize(pageSize);
            productPageBean.setPageIndex(pageIndex);
            List<Product> productList = dao.getByProName(proName,(pageIndex-1)*pageSize,pageSize, connection);
            productPageBean.setList(productList);
        }
        BaseDao.closeResource(connection,null,null,null);
        return productPageBean;
    }
}
