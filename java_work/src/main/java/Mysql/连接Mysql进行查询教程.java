package Mysql;

import java.sql.*;

public class 连接Mysql进行查询教程 {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.1.150:3306/attest_test";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "attest";
    static final String PASS = "attest123";

    static int SQL() {

        Connection conn = null;
        Statement stmt = null;
        int i = 0;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql="SELECT id, username, mobile FROM user";
            ResultSet rs = stmt.executeQuery(sql);


            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
//                String content = rs.getString("content");
//                String yzm=content.replaceAll("\\D", "");   //正则表达式提取数字，非数字用null表示
//                System.out.println("验证码是："+yzm);
//                i=Integer.parseInt(yzm);      //字符串转换整数型
//                System.out.println("完成获取验证码int类型："+i);
//                break;
                int id = rs.getInt("id");
                String username = rs.getString("username");
                long mobile = rs.getLong("mobile");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 用户名: " + username);
                System.out.print(", 手机号: " + mobile);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("return获取验证码："+i);
        return i;

    }

    public static void main(String[] args) {
        SQL();
    }
}

