
package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class LianJie_Mysql {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";   //mysql连接驱动
    private static final String URL = "jdbc:mysql://192.168.1.150:3306/test?";   //连接地址和表名
    private static final String USERRNAME = "attest";          ///账户密码
    private static final String PASSWORD = "attest123";


    public static Connection LJ_Mysql() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERRNAME, PASSWORD);
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }return conn;
    }

    public static void close(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  //类中自带封装关闭连接的方法，就不用到调用的类中处理异常了
    }

}

class Lianjie_test {
    public static void main(String[] args) {
        Connection conn = LianJie_Mysql.LJ_Mysql();//利用封装好的类名来调用连接方法便可
        System.out.println("成功连接数据库");
        LianJie_Mysql.close(conn);//同样利用类名调用关闭方法即可
        //System.out.println(conn.isValid(1000));  //查看数据库是否正常断开，false则已断开
    }
}
