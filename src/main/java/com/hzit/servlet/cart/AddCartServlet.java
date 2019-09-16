package com.hzit.servlet.cart;

import com.hzit.bean.CartItem;
import com.hzit.bean.User;
import com.hzit.dao.CartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddCartServlet", urlPatterns = "/addCart")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.获取添加商品及数量
        String pid = request.getParameter("pid");
        String numStr = request.getParameter("num");
        int num = numStr == null ? 1 : Integer.parseInt(numStr);

        //1.1判断是否登录，如果没有登录 跳转到登录界面
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo == null) //尚未登录
        {
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        } else {
            User user = (User)userInfo;
            //2.判断数据库当中是否存在对应的商品
            CartDao cartDao = new CartDao();
            int count = cartDao.findProductCount(user.getUid(), pid);

            CartItem cartItem = new CartItem();
            cartItem.setCount(num);
            cartItem.setPid(pid);
            cartItem.setUserid(user.getUid());

            if(count>0) //存在 修改
            {
                cartDao.updateCartItem(cartItem);
            }else { //添加
                cartDao.insertCartItem(cartItem);
            }


            //3.如果存在，数据添加
            //4.如果不存在，添加一条新的记录

            response.sendRedirect(request.getContextPath()+"/toCart");

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
