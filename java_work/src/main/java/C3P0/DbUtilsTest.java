package C3P0;

import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;


public class DbUtilsTest {
    public static void main(String[] args) {
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        String sql1 = "insert into user (id,username,nickname,mobile) values(\"85\",\"13899998880\",\"阿瑟东\",\"13388899999\")";
        String sql2 = "select * from user";
        String sql3 ="delete from user where id = 85";
        String sql4 ="update user set id=\"822\",username=\"13311112222\" where nickname=\"sdasd\" and mobile = \"2\"";
        String sqlPdd=" UPDATE flight_monitor set virtual_time =\"2019-10-31 18:25:35\" where id =1081";
        String sqlPddSele="SELECT id,budget_price,actual_price ,virtual_time,has_virtual FROM flight_monitor where id=1081";
        try {
//            runner.update(sql1);   //dbuntils中将 删 增 改 都封装到了 update方法内，全部使用同一个方法名即可，SQL语句要写对
//            runner.update(sqlPdd);
//            int J =runner.update(sql3);
//            System.out.println("受影响的行： "+J);
//            List list = (List) runner.query(sql2, new BeanListHandler(DbUser.class)); //BeanListHandler可以选择list，map
            List list = (List) runner.query(sql2, new BeanListHandler(DbUser.class));
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
