
package Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Mysql.LianJie_Mysql.LJ_Mysql;

public class FZ_select {
    static String i2 = null;   //如果想在方法，循环中的值能被return或者被调用，则需要在前面定义好
    private static String  SELECT(String sql){
        Connection conn = LJ_Mysql();
        PreparedStatement stmt;

        try {
            stmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {  //这一段将会把查询到的所有数据展示
                    System.out.print(rs.getString(i) + "\t");
//                    if ((i == 2) && (rs.getString(i).length() < 1)) {   //不知道这句有什么用
//                        System.out.print("\t");
//                    }
                    i2=rs.getString(i); //只会等于最后一个查询到的数据(最后一条列的最后一行）
                    //i2=rs.getString(i).replaceAll("\\D","");   //将字符串中的数字提取，当获取到的参数为null或者其他无法转化的。会报错
                    //i3=Integer.parseInt(i2);   //需要时将字符串类型转换为整数型
                }System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("方法内return前输出："+i2);
        LianJie_Mysql.close(conn); ///关闭数据库连接
        return i2;
    }

    public static void main(String[] args) throws SQLException {
        SELECT("select * from user"); //where destination= 18757120810 limit 3";);
        System.out.println("调用输出："+i2);
    }
}
