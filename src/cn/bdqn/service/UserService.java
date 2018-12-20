package cn.bdqn.service;

import cn.bdqn.entity.User;

import java.util.List;

public interface UserService {
    int add(User user);

    int del(int id);

    int update(User user);

    List<User> findAll();

    User findById(int id);

}
