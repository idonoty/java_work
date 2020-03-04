package Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Mysql.LianJie_Mysql.LJ_Mysql;

public class Mysql_insert {
    private static int insert(Mysql_table.user canshu) {
        Connection conn = LJ_Mysql();
        int i = 0;
        String sql = "insert into user (id,username,nickname,mobile) values(?,?,?,?)"; //若数据库表里面列规定参数不能为空，而这里没添加参数，就会报错
        PreparedStatement stmt;
        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, canshu.getId());
            stmt.setString(2, canshu.getUsername());
            stmt.setString(3, canshu.getNickname());
            stmt.setString(4,canshu.getMobile());
            i = stmt.executeUpdate(); //不用i就无法添加数据，不知道为啥
            stmt.close();
            conn.close();
            System.out.println("添加成功(*￣︶￣)!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LianJie_Mysql.close(conn);
        return i;
    }

    public static void main(String[] args) {
        Mysql_table.user u =new Mysql_table.user("82","13899998880","阿瑟东","13388899999");  //实例化类，填入需要插入的参数
        insert(u);
    }
}