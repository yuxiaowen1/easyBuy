package cn.bdqn.dao;

import cn.bdqn.entity.News;

import java.sql.Connection;
import java.util.List;

public interface NewsDao {
    int save(News news, Connection connection);

    int del(int id, Connection connection);

    int update(News news, Connection connection);

    List<News> getAll(Connection connection);

    News getById(int id, Connection connection);
}
