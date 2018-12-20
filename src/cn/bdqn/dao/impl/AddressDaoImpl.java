package cn.bdqn.dao.impl;

import cn.bdqn.dao.AddressDao;
import cn.bdqn.dao.BaseDao;
import cn.bdqn.entity.Address;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

public class AddressDaoImpl extends BaseDao<Address> implements AddressDao {
    @Override
    public int save(Address address, Connection connection) {
        String sql = " INSERT INTO `easybuy_user_address`(`userId`,`address`,`createTime`,`isDefault`,`remark`) VALUE( ? , ? , ? , ? , ? ) ";
        return super.executeUpdate(sql,new Object[]{address.getUserId(),address.getAddress(),address.getCreateDate(),address.getIsDefault(),address.getRemark()},connection);
    }

    @Override
    public int del(int id, Connection connection) {
        return 0;
    }

    @Override
    public int update(Address address, Connection connection) {
        return 0;
    }

    @Override
    public List<Address> getAll(Connection connection) {
        String sql = " select * from easybuy_user_address ";
        return super.executeQuery(sql,null,connection);
    }

    @Override
    public List<Address> getAllByUserId(int userId, Connection connection) {
        String sql = " select * from easybuy_user_address where userId = ? ";
        return super.executeQuery(sql,new Object[]{userId},connection);
    }

    @Override
    public Address getById(int id, Connection connection) {
        String reset = " UPDATE `easybuy_user_address` SET `isDefault`=0 WHERE `userId` = ? ";
        super.executeUpdate(reset,new Object[]{id},connection);
        String sql = " select * from easybuy_user_address where id = ? ";
        return super.executeQueryOnly(sql,new Object[]{id},connection);
    }

    @Override
    public Address getByIsDefault(int userId, Connection connection) {
        String sql = " select * from easybuy_user_address where  userId = ? and isDefault = 1 ";
        return super.executeQueryOnly(sql,new Object[]{userId},connection);
    }

    @Override
    public Address getEntity(ResultSet rs) {
        Address address = null;
        try {
            int id = rs.getInt("id");
            int userId = rs.getInt("userId");
            String address1 = rs.getString("address");
            Date createDate = new Date(rs.getDate("createTime").getTime());
            int isDefault = rs.getInt("isDefault");
            String remark = rs.getString("remark");
            address = new Address(id,userId,address1,createDate,isDefault,remark);
        }catch (Exception e){
            e.printStackTrace();
        }
        return address;
    }
}
