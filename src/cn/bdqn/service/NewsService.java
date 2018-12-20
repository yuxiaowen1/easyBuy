package cn.bdqn.service;

import cn.bdqn.entity.News;

import java.util.List;

public interface NewsService {

    int add(News news);

    int del(int id);

    int update(News news);

    List<News> findAll();

    News findById(int id);

}
