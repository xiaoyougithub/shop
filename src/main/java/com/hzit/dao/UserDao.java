package com.hzit.dao;

import com.hzit.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 用户相关的操作
 */
public class UserDao extends BaseDao {


    /**
     * 用户添加
     *
     * @param user
     * @return
     */
    public int insertUser(User user) {

        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?)";

        int row = this.executeUpdate(sql, "user_001", "admin", "1234", "张武", "zhangwu@qq.com", "18812345678", new Date(), "男", "1", "xxxx");
        System.out.println(row + "----->");
        return row;
    }


    /**
     * 根据用户名查询 user对象
     *
     * @param username
     * @return
     */
    public User findUserByUsername(String username) {
        //1.获取连接
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        //2.语句对象
        String sql = "SELECT * FROM user WHERE username=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);

            rs = statement.executeQuery();

            if(rs.next())
            {
                String uid = rs.getString("uid");
                String username1 = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                java.sql.Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                int state = rs.getInt("state");
                String code = rs.getString("code");

                User user = new User(uid,username,password,name,email,telephone,birthday,sex,state,code);

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.执行

        //4.遍历结果集

        //5.封装成user对象
        return null;
    }


    public static void main(String[] args) {
        new UserDao().insertUser(null);
    }

}
