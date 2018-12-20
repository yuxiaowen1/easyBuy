package cn.bdqn.service.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.NewsDao;
import cn.bdqn.dao.impl.NewsDaoImpl;
import cn.bdqn.entity.News;
import cn.bdqn.service.NewsService;

import java.sql.Connection;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private NewsDao dao;

    @Override
    public int add(News news) {
        return 0;
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public int update(News news) {
        return 0;
    }

    @Override
    public List<News> findAll() {
        //获取数据库连接
        Connection connection = BaseDao.getConnection();
        try {
            dao = new NewsDaoImpl();
            return dao.getAll(connection);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有新闻时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
    }

    @Override
    public News findById(int id) {
        return null;
    }
}
