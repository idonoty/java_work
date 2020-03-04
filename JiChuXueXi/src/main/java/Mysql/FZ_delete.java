package Mysql;
import java.sql.*;

import static Mysql.LianJie_Mysql.LJ_Mysql;

public class FZ_delete {
    private static int delete(String sql) {
        Connection conn = LJ_Mysql();
        int i = 0;
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("受影响的行: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) {
        delete("delete from user where username = 13899998881");
    }
}
