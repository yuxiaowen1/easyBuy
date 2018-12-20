package cn.bdqn.dao.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.NewsDao;
import cn.bdqn.entity.News;

import java.sql.*;
import java.util.List;
import java.util.Date;

public class NewsDaoImpl extends BaseDao<News> implements NewsDao {
    @Override
    public News getEntity(ResultSet rs) {
        News news = null;
        try {
            if (rs!=null){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Date createTime = new Date(rs.getTimestamp("createTime").getTime());
                news = new News(id,title,content,createTime);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public int save(News news, Connection connection) {
        String sql = "";
        return super.executeUpdate(sql,new Object[]{news.getTitle(),news.getContent(),news.getCreateTime()},connection);
    }

    @Override
    public int del(int id, Connection connection) {
        String sql = "";
        return super.executeUpdate(sql,new Object[]{id},connection);
    }

    @Override
    public int update(News news, Connection connection) {
        String sql = "";
        return super.executeUpdate(sql,new Object[]{news.getTitle(),news.getContent(),news.getCreateTime()},connection);
    }

    @Override
    public List<News> getAll(Connection connection) {
        String sql = "select * from easybuy_news ";
        return super.executeQuery(sql,null,connection);
    }

    @Override
    public News getById(int id, Connection connection) {
        String sql = "";
        return super.executeQueryOnly(sql,new Object[]{id},connection);
    }
}
