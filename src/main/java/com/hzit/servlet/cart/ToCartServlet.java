package com.hzit.servlet.cart;

import com.hzit.bean.CartItem;
import com.hzit.bean.User;
import com.hzit.dao.CartDao;
import com.hzit.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToCartServlet", urlPatterns = "/toCart")
public class ToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        //1.1判断是否登录，如果没有登录 跳转到登录界面
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo == null) //尚未登录
        {
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        } else {
            User user = (User) userInfo;
            CartDao cartDao = new CartDao();
            List<CartItem> cartList = cartDao.findCartList(user.getUid());

            request.setAttribute("cartList", cartList);

            request.getRequestDispatcher("/jsp/shopcart.jsp").forward(request, response);

        }


    }
}
