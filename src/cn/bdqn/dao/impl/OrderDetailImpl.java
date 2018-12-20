package cn.bdqn.dao.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.OrderDetailDao;
import cn.bdqn.entity.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class OrderDetailImpl extends BaseDao<OrderDetail> implements OrderDetailDao {
    @Override
    public OrderDetail getEntity(ResultSet rs) {
        OrderDetail orderDetail = null;
        try {
            //`id``orderId``productId``quantity``cost`
            if (rs!=null){
                int id = rs.getInt("id");
                int orderId = rs.getInt("orderId");
                int productId = rs.getInt("productId");
                int quantity = rs.getInt("quantity");
                float cost = rs.getFloat("cost");
                orderDetail = new OrderDetail(id,orderId,productId,quantity,cost);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderDetail;
    }

    @Override
    public int save(OrderDetail orderDetail, Connection connection) {
        String sql = " INSERT INTO `easybuy_order_detail` (`orderId`,`productId`,`quantity`,`cost`) VALUE( ? , ? , ? , ? ) ";
        return super.executeUpdate(sql,new Object[]{orderDetail.getOrderId(),orderDetail.getProductId(),orderDetail.getQuantity(),orderDetail.getCost()},connection);
    }

    @Override
    public List<OrderDetail> findByOrderId(int orderId, Connection connection) {
        String sql = " select * from `easybuy_order_detail` where orderId = ? ";
        return super.executeQuery(sql,new Object[]{orderId},connection);
    }
}
