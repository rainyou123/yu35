package servlet;

import javax.servlet.*;
import java.io.IOException;

public class QuickStartServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init running.....");
        System.out.println(servletConfig.getServletName());//输出QuickStartServlet
        System.out.println(servletConfig.getInitParameter("driver"));
    }
    @Override
    public void destroy() {
        System.out.println("destory running.....");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("serivce running.....");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }


}
