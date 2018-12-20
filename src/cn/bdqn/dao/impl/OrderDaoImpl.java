package cn.bdqn.dao.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.OrderDao;
import cn.bdqn.entity.Order;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.ResultSet;
import java.util.List;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

    @Override
    public Order getEntity(ResultSet rs) {
        Order order = null;
        try {
            if (rs != null){
                //`id``userId``loginName``userAddress``createTime``cost``serialNumber`
                int id = rs.getInt("id");
                int userId = rs.getInt("userId");
                String loginName = rs.getString("loginName");
                String userAddress = rs.getString("userAddress");
                Date createTime = rs.getDate("createTime");
                Timestamp timestamp = new Timestamp(createTime.getTime());
                float cost = rs.getFloat("cost");
                String serialNumber = rs.getString("serialNumber");
                order = new Order(id,userId,loginName,userAddress, timestamp,cost,serialNumber);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public int save(Order order, Connection connection) {
        String sql = " INSERT INTO `easybuy_order` (`userId`,`loginName`,`userAddress`,`createTime`,`cost`,`serialNumber`) VALUE( ? , ? , ? , ? , ? , ?); ";
        return super.executeUpdate(sql,new Object[]{order.getUserId(),order.getLoginName(),order.getUserAddress(),order.getCreateTime(),order.getCost(),order.getSerialNumber()},connection);
    }

    @Override
    public int del(int id, Connection connection) {
        return 0;
    }

    @Override
    public int update(Order order, Connection connection) {
        return 0;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findByUserId(int userId, Connection connection) {
        String sql = " select * from easybuy_order where userId = ?  ";
        return super.executeQuery(sql,new Object[]{userId},connection);
    }

    @Override
    public Order findByUserIdAndAddress(int userId, String address, Connection connection) {
        String sql = " select * from easybuy_order where userId = ? and userAddress = ?  ";
        return super.executeQueryOnly(sql,new Object[]{userId,address},connection);
    }
}
