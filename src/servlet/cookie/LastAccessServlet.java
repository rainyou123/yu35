package servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd+hh:mm:ss");
        String s=format.format(date);
        Cookie cookie=new Cookie("LastTime",s);
        cookie.setMaxAge(600);
        resp.addCookie(cookie);

        Cookie[] cookies = req.getCookies();
        String LastTime=null;
        if(cookies!=null){
            for(Cookie c:cookies){
                if(c.getName().equals("LastTime")){
                    LastTime=c.getValue();
                    LastTime=LastTime.replace("+"," ");
                }
            }
        }
        if(LastTime==null){
            resp.getWriter().write("您是第一次访问!");
        }else{
            resp.getWriter().write("您的上次访问时间"+LastTime);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
