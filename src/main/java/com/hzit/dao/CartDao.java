package com.hzit.dao;

import com.hzit.bean.CartItem;
import com.hzit.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao extends  BaseDao {


    /**
     * 根据 用户和商品的id查询数据是否存在
     * @param userid
     * @param pid
     * @return
     */
    public int findProductCount(String userid,String pid) {
        //1.获取连接
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        //2.语句对象
        String sql = "SELECT COUNT(1) cnt FROM cartitem WHERE userid=? AND pid=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,userid);
            statement.setString(2,pid);

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


    public int insertCartItem(CartItem cartItem){
        String sql = "INSERT INTO cartItem(count,pid,userid) VALUES(?,?,?)";
        int row = this.executeUpdate(sql, cartItem.getCount(), cartItem.getPid(), cartItem.getUserid());
        if(row>0)
        {
            System.out.println("添加成功");
        }
        return row;
    }

    public int updateCartItem(CartItem cartItem){
        String sql = "UPDATE cartitem SET count=count+? WHERE userid=? AND pid=?";
        int row = this.executeUpdate(sql, cartItem.getCount(), cartItem.getUserid(), cartItem.getPid());
        if(row>0)
        {
            System.out.println("修改成功");
        }
        return row;
    }


    public List<CartItem> findCartList(String userid){

        List<CartItem> cartItems = new ArrayList<>();

        //1.获取连接
        Connection connection = this.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        //2.语句对象
        String sql = "SELECT u.`uid`,p.`pid`,p.`pname`,p.`pimage`,p.`shop_price`,c.`count` FROM cartitem  c INNER JOIN product p ON  c.`pid`=p.`pid` INNER JOIN `user` u ON c.`userid`=u.`uid` WHERE u.`uid`=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,userid);
            rs = statement.executeQuery();
            while(rs.next()) {

                String uid = rs.getString("uid");
                String pid = rs.getString("pid");
                String pname = rs.getString("pname");
                String pimage = rs.getString("pimage");
                int shopPrice = rs.getInt("shop_price");
                int count = rs.getInt("count");// 购买数量

                CartItem cartItem = new CartItem();
                cartItem.setUserid(uid);
                cartItem.setCount(count);
                cartItem.setPid(pid);

                //补全商品信息
                Product product = new Product();
                product.setPid(pid);
                product.setPname(pname);
                product.setPimage(pimage);
                product.setShopPrice(shopPrice);

                cartItem.setProduct(product); //添加商品
                cartItems.add(cartItem);

            }
            return cartItems;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection, statement, rs);
        }
        return null;
    }



}
