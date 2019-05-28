package servlet;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pool.C3P0Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        login(username,password,resp);
        System.out.println(username + "," + password);
    }
    public void login(String username , String password ,HttpServletResponse resp){
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select * from t_user where uname = ? and upassword = ?";
            User user = qr.query(sql, new BeanHandler<>(User.class), username, password);
            //设计编码格式 要不中文可能乱码
            resp.setContentType("text/html;charset=utf-8");
            if(null!=user){
                resp.getWriter().write("登录成功");
            }else{
                resp.getWriter().write("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
