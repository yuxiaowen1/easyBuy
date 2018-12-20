package cn.bdqn.dao;

import cn.bdqn.entity.ProCategory;

import java.sql.Connection;
import java.util.List;

public interface ProCategoryDao {

    int save(ProCategory proCategory, Connection connection);

    int del(int id, Connection connection);

    int update(ProCategory proCategory, Connection connection);

    List<ProCategory> getAll(Connection connection);

    ProCategory getById(int id, Connection connection);

    List<ProCategory> getByParentId(int parentId, Connection connection);

    List<ProCategory> getByType(int type, Connection connection);
}
