package cn.bdqn.service.impl;

import cn.bdqn.dao.AddressDao;
import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.impl.AddressDaoImpl;
import cn.bdqn.entity.Address;
import cn.bdqn.service.AddressService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressDao dao;

    @Override
    public int add(Address address){
        Connection connection = BaseDao.getConnection();
        try {
            dao = new AddressDaoImpl();
            connection.setAutoCommit(false);
            int save = dao.save(address, connection);
            if (save>0){
                connection.commit();
                connection.setAutoCommit(true);
            }
            return save;
        }catch (Exception e){
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null,null);
        }
        return 0;
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public int update(Address address) {
        return 0;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address findById(int id) {
        return null;
    }

    @Override
    public Address findByIsDefault(int id) {
        Connection connection = BaseDao.getConnection();
        dao = new AddressDaoImpl();
        Address address = dao.getByIsDefault(id, connection);
        BaseDao.closeResource(connection,null,null,null);
        return address;
    }

    @Override
    public List<Address> getAllByUserId(int userId) {
        Connection connection = BaseDao.getConnection();
        dao = new AddressDaoImpl();
        List<Address> allByUserId = dao.getAllByUserId(userId, connection);
        BaseDao.closeResource(connection,null,null,null);
        return allByUserId;
    }
}
