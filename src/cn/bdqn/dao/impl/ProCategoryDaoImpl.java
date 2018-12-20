package cn.bdqn.dao.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.ProCategoryDao;
import cn.bdqn.entity.ProCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class ProCategoryDaoImpl extends BaseDao<ProCategory> implements ProCategoryDao {
    @Override
    public ProCategory getEntity(ResultSet rs) {
        ProCategory proCategory = null;
        try {
            //`id``name``parentId``type``iconClass`
            int id = rs.getInt("id");
            int parentId = rs.getInt("parentId");
            int type = rs.getInt("type");
            String name = rs.getString("name");
            String iconClass = rs.getString("iconClass");
            proCategory = new ProCategory(id,name,parentId,type,iconClass);
        }catch (Exception e){
            e.printStackTrace();
        }
        return proCategory;
    }

    @Override
    public int save(ProCategory proCategory, Connection connection) {
        return 0;
    }

    @Override
    public int del(int id, Connection connection) {
        return 0;
    }

    @Override
    public int update(ProCategory proCategory, Connection connection) {
        return 0;
    }

    @Override
    public List<ProCategory> getAll(Connection connection) {
        String sql = "select * from easybuy_product_category ";
        return super.executeQuery(sql,null,connection);
    }

    @Override
    public ProCategory getById(int id, Connection connection) {
        String sql = " select * from easybuy_product_category where id = ? ";
        return super.executeQueryOnly(sql,new Object[]{id},connection);
    }

    @Override
    public List<ProCategory> getByParentId(int parentId, Connection connection) {
        String sql = " select * from easybuy_product_category where parentId = ? ";
        return super.executeQuery(sql,new Object[]{parentId},connection);
    }

    @Override
    public List<ProCategory> getByType(int type, Connection connection) {
        String sql = " select * from easybuy_product_category where type = ? ";
        return super.executeQuery(sql,new Object[]{type},connection);
    }
}
