package Mysql;

import java.sql.*;

import static Mysql.LianJie_Mysql.LJ_Mysql;

public class Mysql_update {
    private static int update(Mysql_table.user canshu) {
        Connection conn = LJ_Mysql();
        int i = 0;
        String sql = "update user set id='" + canshu.getId() + "',nickname='" + canshu.getNickname() + "' where username='" + canshu.getUsername() + "'";
        PreparedStatement stmt;
        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            i = stmt.executeUpdate();
            System.out.println(sql);
            System.out.println("受影响的行: " + i);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) {
        Mysql_table.user u = new Mysql_table.user("141","13899998889","sdasd","555");
        update(u);
    }
}
