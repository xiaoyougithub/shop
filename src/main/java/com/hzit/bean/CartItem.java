package com.hzit.bean;

public class CartItem
{

    private int cartid;
    private int count; //购买数量
    private int shopPrice;//小计
    private String pid; //商品ID
    private String userid; //用户ID
    private Product product;


    public CartItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartid=" + cartid +
                ", count=" + count +
                ", shopPrice=" + shopPrice +
                ", pid='" + pid + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public CartItem(int cartid, int count, int shopPrice, String pid, String userid) {

        this.cartid = cartid;
        this.count = count;
        this.shopPrice = shopPrice;
        this.pid = pid;
        this.userid = userid;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(int shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
