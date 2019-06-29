package web;
import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProductInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        ProductService productService = new ProductService();
        Product product = null;
        try {
            product = productService.getProductById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("product" , product);
        req.getRequestDispatcher("product_info.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
