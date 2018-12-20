package cn.bdqn.service;

import cn.bdqn.entity.ProCategory;

import java.sql.Connection;
import java.util.List;

public interface ProCategoryService {

    int save(ProCategory proCategory);

    int del(int id);

    int update(ProCategory proCategory);

    List<ProCategory> getAll();

    ProCategory getById(int id);

    List<ProCategory> getByParentId(int parentId, Connection connection);

    List<ProCategory> getByType(int type);
}
