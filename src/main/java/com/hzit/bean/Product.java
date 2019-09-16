package com.hzit.bean;

import java.util.Date;

public class Product {

    private String pid;
    private String pname;
    private int marketPrice;
    private int shopPrice;
    private String pimage;
    private Date pdate;
    private int isHot;
    private String pdesc;
    private Integer pflag; //默认值 null
    private String cid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(int marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(int shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", pimage='" + pimage + '\'' +
                ", pdate=" + pdate +
                ", isHot=" + isHot +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                '}';
    }

    public Product() {
    }

    public Product(String pid, String pname, int marketPrice, int shopPrice, String pimage, Date pdate, int isHot, String pdesc, Integer pflag, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.marketPrice = marketPrice;
        this.shopPrice = shopPrice;
        this.pimage = pimage;
        this.pdate = pdate;
        this.isHot = isHot;
        this.pdesc = pdesc;
        this.pflag = pflag;
        this.cid = cid;
    }
}
