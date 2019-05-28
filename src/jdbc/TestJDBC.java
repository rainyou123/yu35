package jdbc;
import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.*;

public class TestJDBC {
    @Test
    public void testQuery(){
        //都需要关掉
        Connection conn=null;
        Statement st=null;
        ResultSet rt=null;
        try {
            conn = JDBCUtils.getConnection();
////            1.注册驱动  加载驱动包
//            Class.forName("com.mysql.jdbc.Driver");
////            2.获取连接
//            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/yu35", "root", "wangyu");
//            3、获取stateMent对象
             st = conn.createStatement();
//            4、编写sql语句
            String sql = "select * from t_user";
//            5、执行sql语句
//            ResultSet对象表示查询结果集，只有在执行查询操作后才会有结果集的产生。结果集是一个二维的表格，有行有列。
            rt = st.executeQuery(sql);
            System.out.println(rt);
//            用getInt要确定里头的类型 getString就可以
            while (rt.next()){
                System.out.println("用户名：" + rt.getString("uname") +"   id:"+rt.getInt(1)+ "   邮箱: " + rt.getString(4) );
            }
//       columnIndex 列 4第四列
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseRes(conn , st , rt);
        }
    }
}
