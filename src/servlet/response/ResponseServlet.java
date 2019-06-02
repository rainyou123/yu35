package servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ResponseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        //设置响应头状态码
        resp.setStatus(500);
        //设置响应头
        resp.addHeader("name","lili");
        resp.addHeader("name","haha");
        resp.addIntHeader("age",15);
        resp.addDateHeader("time",new Date().getTime());
        resp.setHeader("name","dahua");
        //重定向
//        resp.setStatus(302);
//        resp.setHeader("Location","/loginServlet");
//        resp.sendRedirect("/loginyanshi.jsp");
        resp.getWriter().write("我是测试写入功能");
    }
}
