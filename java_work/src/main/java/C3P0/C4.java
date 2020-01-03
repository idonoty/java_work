package C3P0;

import Mysql.LianJie_Mysql;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class C4 {
    private static DataSource dataSource=null;
    static{
        dataSource=new ComboPooledDataSource("mysql");
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void closeConn(Connection conn){
        try {
            if(conn!=null && conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn =C4.getConnection();
        PreparedStatement stmt;

        try {
            stmt = (PreparedStatement)conn.prepareStatement("select * from user");
            ResultSet rs = stmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {  //这一段将会把查询到的所有数据展示
                    System.out.print(rs.getString(i) + "\t");
//                    if ((i == 2) && (rs.getString(i).length() < 1)) {   //不知道这句有什么用
//                        System.out.print("\t");
//                    }

                    //i2=rs.getString(i).replaceAll("\\D","");   //将字符串中的数字提取，当获取到的参数为null或者其他无法转化的。会报错
                    //i3=Integer.parseInt(i2);   //需要时将字符串类型转换为整数型
                }System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }


