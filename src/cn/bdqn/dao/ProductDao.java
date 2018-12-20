package cn.bdqn.dao;

import cn.bdqn.entity.Product;

import java.sql.Connection;
import java.util.List;

public interface ProductDao {

    int save(Product product,Connection connection);

    int delById(int id,Connection connection);

    int upDate(Product product,Connection connection);

    Product getById(int id,Connection connection);

    List<Product> getAll(Connection connection);

    int getCountByCategoryLevel1Id(int categoryLevel1Id, Connection connection);

    List<Product> getByCategoryLevel1Id(int categoryLevel1Id,int startIndex,int pageSize,Connection connection);

    List<Product> getByCategoryLevel1Id(int categoryLevel1Id,Connection connection);

    int getCountByCategoryLevel3Id(int categoryLevel3Id, Connection connection);

    List<Product> getByCategoryLevel3Id(int categoryLevel3Id,int startIndex,int pageSize,Connection connection);

    List<Product> getByCategoryLevel3Id(int categoryLevel3Id,Connection connection);

    List<Product> getByProName(String proName,int startIndex,int pageSize,Connection connection);

    int getCountByProName(String name, Connection connection);

}
