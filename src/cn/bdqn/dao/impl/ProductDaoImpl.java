package cn.bdqn.dao.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.ProductDao;
import cn.bdqn.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class ProductDaoImpl extends BaseDao<Product> implements ProductDao {
    @Override
    public Product getEntity(ResultSet rs) {
        Product product = null;
        try {
            if(rs!=null){
                //`name``description``price``stock``categoryLevel1Id``categoryLevel2Id``categoryLevel3Id``fileName``isDelete`
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                int stock = rs.getInt("stock");
                int categoryLevel1Id = rs.getInt("categoryLevel1Id");
                int categoryLevel2Id = rs.getInt("categoryLevel2Id");
                int categoryLevel3Id = rs.getInt("categoryLevel3Id");
                int isDelete = rs.getInt("isDelete");
                String fileName = rs.getString("fileName");
                product = new Product(id,name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public int save(Product product, Connection connection) {
        return 0;
    }

    @Override
    public int delById(int id, Connection connection) {
        return 0;
    }

    @Override
    public int upDate(Product product, Connection connection) {
        return 0;
    }

    @Override
    public Product getById(int id, Connection connection) {
        String sql = " SELECT * FROM `easybuy_product` where id = ?  ";
        return super.executeQueryOnly(sql,new Object[]{id},connection);
    }

    @Override
    public List<Product> getAll(Connection connection) {
        String sql = " SELECT * FROM `easybuy_product` ";
        return super.executeQuery(sql,null,connection);
    }

    @Override
    public List<Product> getByCategoryLevel1Id(int categoryLevel1Id,int startIndex,int pageSize, Connection connection) {
        String sql = " SELECT * FROM `easybuy_product` WHERE `categoryLevel1Id` = ? limit ?,? ";
        return super.executeQuery(sql,new Object[]{categoryLevel1Id,startIndex,pageSize},connection);
    }

    @Override
    public List<Product> getByCategoryLevel1Id(int categoryLevel1Id, Connection connection) {
        String sql = " SELECT * FROM `easybuy_product` WHERE `categoryLevel1Id` = ? ";
        return super.executeQuery(sql,new Object[]{categoryLevel1Id,},connection);
    }

    @Override
    public int getCountByCategoryLevel1Id(int categoryLevel1Id, Connection connection) {
        String sql = " SELECT count(1) FROM `easybuy_product` WHERE `categoryLevel1Id` = ? ";
        return super.executeQueryCount(sql,new Object[]{categoryLevel1Id},connection);
    }

    @Override
    public List<Product> getByCategoryLevel3Id(int categoryLevel3Id,int startIndex,int pageSize, Connection connection) {
        String sql = " SELECT * FROM `easybuy_product` WHERE `categoryLevel3Id` = ? limit ?,? ";
        return super.executeQuery(sql,new Object[]{categoryLevel3Id,startIndex,pageSize},connection);
    }

    @Override
    public List<Product> getByCategoryLevel3Id(int categoryLevel3Id, Connection connection) {
        String sql = " SELECT * FROM `easybuy_product` WHERE `categoryLevel3Id` = ? ";
        return super.executeQuery(sql,new Object[]{categoryLevel3Id,},connection);
    }

    @Override
    public List<Product> getByProName(String proName,int startIndex,int pageSize, Connection connection) {
        String sql = " SELECT * FROM `easybuy_product` WHERE `name` LIKE CONCAT('%', ? ,'%') limit ?,? ";
        return super.executeQuery(sql,new Object[]{proName,startIndex,pageSize},connection);
    }

    @Override
    public int getCountByProName(String name, Connection connection) {
        String sql = " SELECT count(1) FROM `easybuy_product` WHERE name LIKE CONCAT('%', ? ,'%') ";
        return super.executeQueryCount(sql,new Object[]{name},connection);
    }

    @Override
    public int getCountByCategoryLevel3Id(int categoryLevel3Id, Connection connection) {
        String sql = " SELECT count(1) FROM `easybuy_product` WHERE `categoryLevel3Id` = ? ";
        return super.executeQueryCount(sql,new Object[]{categoryLevel3Id},connection);
    }
}
