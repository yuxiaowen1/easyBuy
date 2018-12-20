package cn.bdqn.dao;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public abstract class BaseDao<T> {

    public static Connection getConnection(){
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/easyBuy");
            return dataSource.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException("context  not found");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    <Resource name="jdbc/easyBuy" auth="Container" type="javax.sql.DataSource"
    maxActive="100" maxIdle="30" maxWait="10000"
    username="root" password="root" driverClassName="com.mysql.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/easyBuy"/>

    */
/*
    public static Connection getConnection1(){
        try {
            ConfigManger configManger = ConfigManger.getInstence();
            Class.forName(configManger.getValue("driver"));
            return DriverManager.getConnection(configManger.getValue("url"), configManger.getValue("username"), configManger.getValue("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库驱动时出错！",e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接时出错！",e);
        }

    }*/

    public int executeUpdate(String sql,Object[] params,Connection connection){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            if (params!=null){
                for (int i = 0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    public List<T> executeQuery(String sql,Object[] params,Connection connection){
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            //获得语句集对象,用于发送sql
            ps = connection.prepareStatement(sql);
            if (params!=null){
                for (int i = 0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            //处理结果,执行sql获得结果集
            rs = ps.executeQuery();
            while (rs.next()){
                T t = getEntity(rs);
                list.add(t);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource(null,null,ps,rs);
        }
        return null;
    }

    public T executeQueryOnly(String sql,Object[] params,Connection connection){
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            //获得语句集对象,用于发送sql
            ps = connection.prepareStatement(sql);
            if (params!=null){
                for (int i = 0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            //处理结果,执行sql获得结果集
            rs = ps.executeQuery();
            T t = null;
            if (rs.next()){
                t = getEntity(rs);
            }
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource(null,null,ps,rs);
        }
        return null;
    }

    public int executeQueryCount(String sql,Object[] params,Connection connection){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获得语句集对象,用于发送sql
            ps = connection.prepareStatement(sql);
            if (params!=null){
                for (int i = 0;i<params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
            //处理结果,执行sql获得结果集
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeResource(null,null,ps,rs);
        }
        return -1;
    }

    public abstract T getEntity(ResultSet rs);

    public static void closeResource(Connection connection, Statement statement, PreparedStatement ps,ResultSet rs){
        try {
            if (connection!=null) {
                connection.close();
            }
            if (statement!=null) {
                statement.close();
            }
            if (ps!=null) {
                ps.close();
            }
            if (rs!=null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
