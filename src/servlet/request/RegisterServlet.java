package servlet.request;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import pool.C3P0Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //解决从前端获取的乱码问题
            req.setCharacterEncoding("UTF-8");
            //解决输入到前端乱码问题
            resp.setContentType("text/html;charset=utf-8");
            String hobby="";
            User u=new User();
            Map<String, String[]> parameterMap = req.getParameterMap();
            BeanUtils.populate(u,parameterMap);
            //由于hobby是好几个 所以需要自己set
            Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
            for(Map.Entry<String, String[]> e:entries){
                if(e.getKey().equals("hobby")){
                    for(String h:e.getValue()){
                        hobby+=h+",";
                    }
                }
            }
            u.setHobby(hobby);
            register(u,req,resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void register(User u,HttpServletRequest req, HttpServletResponse resp){
        try {
            QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
            System.out.println("qr = " + qr);
            String sql="insert into t_user values(null,?,?,?,?,?,?)";
            int rows = qr.update(sql, u.getUname(), u.getUpassword(), u.getEmail(), u.getHobby(), u.getSex(), u.getCode());
            if(rows>0){
                //重定向
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
