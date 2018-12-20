package cn.bdqn.service;

import cn.bdqn.entity.Product;
import cn.bdqn.utils.PageBean;

import java.sql.Connection;
import java.util.List;

public interface ProductService {

    int add(Product product);

    int delById(int id);

    int upDate(Product product);

    Product findById(int id);

    List<Product> findAll();

    PageBean<Product> findByCategoryLevel1Id(int categoryLevel3Id,int pageIndex,int pageSize);

    List<Product> findByCategoryLevel1Id(int categoryLevel3Id);

    PageBean<Product> findByCategoryLevel3Id(int categoryLevel3Id, int pageIndex, int pageSize);

    List<Product> findByCategoryLevel3Id(int categoryLevel3Id);

    PageBean<Product> findByProName(String proName, int pageIndex, int pageSize);
}
