package cn.bdqn.dao.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.UserDao;
import cn.bdqn.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public int save(User user, Connection connection) {
        String sql = "INSERT INTO `easybuy_user` (`loginName`,`userName`,`password`,`email`,`mobile`,`identityCode`) VALUE(?,?,?,?,?,?)";
        return super.executeUpdate(sql,new Object[]{user.getLoginName(),user.getUserName(),user.getPassword(),user.getEmail(),user.getMobile(),user.getIdentityCode()},connection);
    }

    @Override
    public int del(int id, Connection connection) {
        return 0;
    }

    @Override
    public int update(User user, Connection connection) {
        return 0;
    }

    @Override
    public List<User> getAll(Connection connection) {
        String sql = " select * from `easybuy_user` ";
        return super.executeQuery(sql,null,connection);
    }

    @Override
    public User getById(int id, Connection connection) {
        return null;
    }

    @Override
    public User getEntity(ResultSet rs) {
        User user = null;
        try{
            if (rs!=null){
                //`id``loginName``userName``password``sex``identityCode``email``mobile``type`
                int id = rs.getInt("id");
                int sex = rs.getInt("sex");
                int type = rs.getInt("type");
                String loginName = rs.getString("loginName");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String identityCode = rs.getString("identityCode");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");
                user = new User(id,sex,type,loginName,userName,password,identityCode,email,mobile);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
