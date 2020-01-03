package C3P0;

import Mysql.LianJie_Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0_2 {
    public static void main(String[] args) {
        new C3P0_2().test1();
    }
    PreparedStatement stmt;
    public void test1() {
        try {
            Connection conn=C3P0_1.getConnection();
            stmt = (PreparedStatement)conn.prepareStatement("select * from user");
            ResultSet rs = stmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {  //这一段将会把查询到的所有数据展示
                    System.out.print(rs.getString(i) + "\t");
                }System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


