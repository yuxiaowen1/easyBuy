package cn.bdqn.service.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.ProCategoryDao;
import cn.bdqn.dao.impl.ProCategoryDaoImpl;
import cn.bdqn.entity.ProCategory;
import cn.bdqn.service.ProCategoryService;
import cn.bdqn.utils.ProCategoryVO;
import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProCategoryServiceImpl implements ProCategoryService {

    private ProCategoryDao dao;

    @Override
    public int save(ProCategory proCategory) {
        return 0;
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public int update(ProCategory proCategory) {
        return 0;
    }

    /**
     * 封装所有菜单类别
     * @return
     */
    @Override
    public List<ProCategory> getAll() {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new ProCategoryDaoImpl();

            List<ProCategoryVO> list = new ArrayList<>();


            List<ProCategory> proCategories = dao.getByParentId(0,connection);
            for (ProCategory proCategory1:proCategories){
                List<ProCategory> proCategories2 = dao.getByParentId(proCategory1.getId(), connection);
                proCategory1.setList(proCategories2);
                for (ProCategory proCategory2:proCategories2){
                    List<ProCategory> proCategories3 = dao.getByParentId(proCategory2.getId(), connection);
                    proCategory2.setList(proCategories3);
                    for (ProCategory proCategory3:proCategories3){
                        proCategory3.setList(dao.getByParentId(proCategory3.getId(), connection));
                    }
                }
            }
            return proCategories;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有商品分类时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
}

    @Override
    public ProCategory getById(int id) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new ProCategoryDaoImpl();
            return dao.getById(id,connection);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询某一商品分类时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
    }

    @Override
    public List<ProCategory> getByParentId(int parentId, Connection connection) {
        dao = new ProCategoryDaoImpl();
        List<ProCategory> byParentId = dao.getByParentId(parentId, connection);
        BaseDao.closeResource(connection,null,null,null);
        return byParentId;
    }

    @Override
    public List<ProCategory> getByType(int type) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new ProCategoryDaoImpl();
            return dao.getByType(type,connection);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询某一商品分类级别时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
    }
}
