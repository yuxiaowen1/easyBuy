package cn.bdqn.dao;

import cn.bdqn.entity.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

    int save(User user, Connection connection);

    int del(int id, Connection connection);

    int update(User user, Connection connection);

    List<User> getAll(Connection connection);

    User getById(int id, Connection connection);
}
