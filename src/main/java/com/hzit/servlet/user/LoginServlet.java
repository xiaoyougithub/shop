package com.hzit.servlet.user;

import com.hzit.bean.User;
import com.hzit.dao.UserDao;
import com.hzit.util.Md5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //2.获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //3.通过用户名去数据库查询user对象
        UserDao userDao = new UserDao();
        User user = userDao.findUserByUsername(username);

        //4.传入的密码和数据的密码是否正确(加密:MD5)
        if (user != null) {
            if (Md5.getMd5String(password).equals(user.getPassword()))  //数据库 已经加密  页面传入的密码 加密后进行比较
            {
                //成功
                //6.成功，保存用户信息。跳转到首页
                session.setAttribute("userInfo",user);
                response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");

            } else {
                System.out.println("用户名或者密码不正确");

                //重定向  至少session域
                session.setAttribute("errorMsg", "用户名或者密码不正确");
                response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
            }
            //5.判断 如果失败 调回登录界面，携带错误提示信息
        } else {
            System.out.println("用户名不存在");
            session.setAttribute("errorMsg", "用户名不存在");
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        }


    }
}
