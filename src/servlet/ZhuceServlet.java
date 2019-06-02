package servlet;

import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ZhuceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String pass=req.getParameter("pass");
        String emails=req.getParameter("email");
        //设计编码格式 要不中文可能乱码
        resp.setContentType("text/html;charset=utf-8");
        if(!password.equals(pass)){
            System.out.println("注册失败，两次密码不相等！");
            resp.getWriter().write("注册失败，两次密码不相等！");
        }else{
            zhuce(username,password,emails,resp);
        }
    }
    public void zhuce(String username, String password, String emails,HttpServletResponse resp){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            String sql="insert into t_user(uname,upassword,email) values(?,?,?)";
            int rows = qr.update(sql, username, password ,emails);
            if(rows>0){
                System.out.println("注册成功！");
                resp.getWriter().write("注册成功");
            }else{
                System.out.println("注册失败！");
                resp.getWriter().write("注册失败");

            }
            resp.setContentType("text/html;charset=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
