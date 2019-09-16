package com.hzit.dao;

import java.sql.*;

/**
 * 基础jdbc类
 */
public class BaseDao {

    /**
     * 获取连接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            //1.加载驱动类 alt+enter:自动补全，提示
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            String url = "jdbc:mysql://localhost:3306/store?characterEncoding=utf8&useSSL=true";
            Connection connection = DriverManager.getConnection(url, "root", "root");

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取连接失败......");
            return null;
        }
    }

    /**
     * 关闭连接
     *
     * @param connection
     * @param statement
     * @param rs
     */
    public void closeAll(Connection connection, Statement statement, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 增删改的公共方法
     *
     * @param sql   执行的sql语句
     * @param param 占位符对应的内容
     * @return
     */
    public int executeUpdate(String sql, Object... param) {
        //1.获取连接
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        //2.获取语句对象
        try {
            statement = connection.prepareStatement(sql);

            //给站位符赋值
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    statement.setObject(i+1,param[i]);
                }
            }

            //3.执行增删改
            int row = statement.executeUpdate();
            return row;

        } catch (Exception e) {
            System.out.println("增删改出现异常....baseDao...");
            e.printStackTrace();
        } finally {
            this.closeAll(connection, statement, null);
        }
        return 0;
    }


}
