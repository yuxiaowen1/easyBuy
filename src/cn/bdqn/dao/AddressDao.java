package cn.bdqn.dao;

import cn.bdqn.entity.Address;

import java.sql.Connection;
import java.util.List;

public interface AddressDao {

    int save(Address address, Connection connection);
    int del(int id, Connection connection);
    int update(Address address, Connection connection);
    List<Address> getAll(Connection connection);
    List<Address> getAllByUserId(int userId,Connection connection);
    Address getById(int id,Connection connection);
    Address getByIsDefault(int isDefault,Connection connection);
}
