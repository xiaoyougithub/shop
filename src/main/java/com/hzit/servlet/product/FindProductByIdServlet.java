package com.hzit.servlet.product;

import com.hzit.bean.Product;
import com.hzit.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindProductByIdServlet", urlPatterns = "/findProductById")
public class FindProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取需要查询的商品id
        String pid = request.getParameter("pid");

        //2.通过jdbc获取商品的详细信息
        ProductDao productDao = new ProductDao();
        Product product = productDao.findProductByPid(pid);

        //3.保存到域中
        request.setAttribute("product",product);

        //4.转发到details.jsp中展示
        request.getRequestDispatcher("/jsp/details.jsp").forward(request,response);
    }
}
