package com.hzit.servlet.product;

import com.hzit.bean.Product;
import com.hzit.dao.ProductDao;
import com.hzit.util.PageResult;
import sun.security.krb5.internal.PAEncTSEnc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/findProductByPage")
public class ProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.获取参数  页码(默认1)  每页大小(默认15)
        String page = req.getParameter("page");
        String size = req.getParameter("size");

        // 三元运算符
        // 当page等于 null的时候，默认mypage=1。否则获取强制转换的类型
        int mypage = page == null ? 1 : Integer.parseInt(page);
        int mysize = size == null ? 15 : Integer.parseInt(size);


        //3.调用jdbc
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.findProductByPage(mypage, mysize);




        //4.获取List存放到域中
        //req.setAttribute("productList", productList);
        // 计算分页条   count/size
        int count = productDao.findProductCount();

        //总页码
        int pages = (count % mysize == 0) ? count / mysize : count / mysize + 1;
        req.setAttribute("pages",pages);

        //分页对象
        PageResult<Product> pageResult = new PageResult();

        pageResult.setCount(count);
        pageResult.setPageCount(pages);
        pageResult.setSize(mysize);
        pageResult.setPage(mypage);
        pageResult.setDataList(productList);
        req.setAttribute("pageResult",pageResult);

        //5.获取页面展示
        req.getRequestDispatcher("/jsp/commodity.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
