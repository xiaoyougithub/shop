package com.hzit.dao;

import com.hzit.bean.Product;
import com.hzit.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends BaseDao {


    /**
     * @param page 当前页码
     * @param size 每页大小
     * @return
     */
    public List<Product> findProductByPage(int page, int size) {

        List<Product> productList = new ArrayList<>();

        //1.获取连接
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        //2.语句对象
        String sql = "SELECT * FROM product limit ?,?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (page - 1) * size);
            statement.setInt(2, size);

            rs = statement.executeQuery();
            while (rs.next()) {
                String pid = rs.getString("pid");
                String pname = rs.getString("pname");
                int marketPrice = rs.getInt("market_price");
                int shopPrice = rs.getInt("shop_price");
                String pimage = rs.getString("pimage");
                Date pdate = rs.getDate("pdate");
                int isHot = rs.getInt("is_hot");
                String pdesc = rs.getString("pdesc");
                Integer flag = rs.getInt("pflag");
                String cid = rs.getString("cid");


                Product product = new Product(pid, pname, marketPrice, shopPrice, pimage, pdate, isHot, pdesc, flag, cid);
                productList.add(product);
            }

            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection, statement, rs);
        }

        //3.执行
        //4.遍历结果集
        //5.封装成user对象
        return null;
    }

    /**
     * 获取总的条数
     *
     * @return
     */
    public int findProductCount() {
        //1.获取连接
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        //2.语句对象
        String sql = "SELECT COUNT(1) cnt FROM product";
        try {
            statement = connection.prepareStatement(sql);

            rs = statement.executeQuery();
            if (rs.next()) {
                int cnt = rs.getInt("cnt");
                return cnt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection, statement, rs);
        }
        return 0;
    }

    public Product findProductByPid(String pid) {


        //1.获取连接
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        //2.语句对象
        String sql = "SELECT * FROM product WHERE pid=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, pid);


            rs = statement.executeQuery();
            if (rs.next()) {
                //String pid = rs.getString("pid");
                String pname = rs.getString("pname");
                int marketPrice = rs.getInt("market_price");
                int shopPrice = rs.getInt("shop_price");
                String pimage = rs.getString("pimage");
                Date pdate = rs.getDate("pdate");
                int isHot = rs.getInt("is_hot");
                String pdesc = rs.getString("pdesc");
                Integer flag = rs.getInt("pflag");
                String cid = rs.getString("cid");


                Product product = new Product(pid, pname, marketPrice, shopPrice, pimage, pdate, isHot, pdesc, flag, cid);
                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection, statement, rs);
        }

        //3.执行
        //4.遍历结果集
        //5.封装成user对象
        return null;
    }
}
