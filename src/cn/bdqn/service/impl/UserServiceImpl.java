package cn.bdqn.service.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.UserDao;
import cn.bdqn.dao.impl.UserDaoImpl;
import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao;

    @Override
    public int add(User user) {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new UserDaoImpl();
            return dao.save(user,connection);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("增加用户时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }

    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        Connection connection = BaseDao.getConnection();
        try {
            dao = new UserDaoImpl();
            return dao.getAll(connection);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有用户时出错",e);
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }

    }

    @Override
    public User findById(int id) {
        return null;
    }
}
