package C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbUserDao {
    public static void main(String[] args) {
       List<DbUser> list = query();
        System.out.println(list);
    }


    private static List<DbUser> query(){
        Connection conn = null;
        Statement statement = null;
        List<DbUser> list = null;

        try {
            conn = JDBCUtils.getConnection();
            //准备sql
            String sql = "select * from user";

            //创建执行sql对象
            statement = conn.createStatement();

            //执行sql，获取返回结果集合
            ResultSet set = statement.executeQuery(sql);
            list = new ArrayList<DbUser>();
            while (set.next()){
                String idString = set.getString("id");
                String username = set.getString("username");
                String nickname = set.getString("nickname");
                String mobile = set.getString("mobile");
                DbUser dbUser = new DbUser();
                dbUser.setId(idString);
                dbUser.setUsername(username);
                dbUser.setNickname(nickname);
                dbUser.setMobile(mobile);
                list.add(dbUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;
    }
}
