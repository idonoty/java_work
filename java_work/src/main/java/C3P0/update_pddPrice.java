package C3P0;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class update_pddPrice {
    public static void main(String[] args) {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql1 = "insert into user (id,username,nickname,mobile) values(\"85\",\"13899998880\",\"阿瑟东\",\"13388899999\")";
        String sql2 = "select * from user";
        String sql3 ="delete from user where id = 85";
        String sql4 ="update user set id=\"822\",username=\"13311112222\" where nickname=\"sdasd\" and mobile = \"2\"";
        try {
//            runner.update(sql1);   //dbuntils中将 删 增 改 都封装到了 update方法内，全部使用同一个方法名即可，SQL语句要写对
//            runner.update(sql4);
//            int J =runner.update(sql3);
//            System.out.println("受影响的行： "+J);
            List list = (List) runner.query(sql2, new BeanListHandler(DbUser.class)); //BeanListHandler可以选择list，map
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
