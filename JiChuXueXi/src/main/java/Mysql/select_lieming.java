package Mysql;

import java.sql.*;

public class select_lieming {
    public static void main(String[] args) {
        Connection conn = null;//定义为空值
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from user order by id desc limit 3 ";//sql语句
        conn = LianJie_Mysql.LJ_Mysql();
        try {
            stmt = conn.createStatement();//创建一个Statement语句对象
            rs = stmt.executeQuery(sql);//执行sql语句
            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println("id:" + id + ",");
                System.out.println("username:" + rs.getString("username") + ",");//直接使用参数
                System.out.println("nickname：" + rs.getString("nickname") + ",");
                System.out.println("mobile：" + rs.getLong("mobile"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            LianJie_Mysql.close(conn);//调用连接类中的方法关闭数据库
        }
    }
}

