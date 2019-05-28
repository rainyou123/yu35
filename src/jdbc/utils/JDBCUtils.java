package jdbc.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        ResourceBundle rb=ResourceBundle.getBundle("db");
        driver=rb.getString("jdbc.driver");
        url=rb.getString("jdbc.url");
        username=rb.getString("jdbc.username");
        password=rb.getString("jdbc.password");

    }
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void releaseRes(Connection conn, Statement st,ResultSet rt){
        if(null!=conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=st){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null!=rt){
            try {
                rt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
