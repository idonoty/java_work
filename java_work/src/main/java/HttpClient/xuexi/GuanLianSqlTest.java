package HttpClient.xuexi;

import C3P0.JDBCUtils;
import WanZheng.java.utils.correlation.MapUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.SQLException;
import java.util.*;

public class GuanLianSqlTest {
    private static Map<String, Object> correlationMap = new LinkedHashMap<String, Object>();
    static String a;
    public static void addSqlCorrelation(String sql) {

//        if(!JSON.isValid(content)) {                          //如果获取不到有效的json数据，则停止运行
//            return;
//        }
        Map sqlreturn = new HashMap();
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        try {
            sqlreturn = runner.query(sql, new MapHandler()); //BeanListHandler可以选择list，map
            a =sqlreturn.toString();           //因为SQL返回的数据带大括号，所以改成String类型去掉大括号
            //前面是去掉大括号，后面是去掉逗号中间的空格（数据库返回时，每个列名前面自动加空格了）
            //若不去掉空格，需要在excel中每个数据库关联前加空格，若全部去掉，会导致返回数据的空格也消失了，所有只把”逗号+空格“替换为”逗号“
            a=a.replaceAll("\\{|\\}", "").replace(", ", ",");
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<String, Object> param = MapUtils.covertStringToMap3(a);    //得到excel文件中检查点下的数据
        if (param != null) {
            Set<String> keys = param.keySet();
            for (String key : keys) {
                Object object = (param.get(key).toString());
                //如果提取的是多个数据
                if (object instanceof List) {
                    int i = 0;
                    List<Object> list = (List<Object>) object;
                    for (Object object_item : list) {
                        correlationMap.put(key + "_g" + (++i), object_item);
                    }
                } else {
                    //如果提取的是单个数据
                    correlationMap.put(key, (param.get(key).toString()));   //关联多个用 ; 分隔
                    System.out.println(correlationMap.getClass());
                }
            }
            System.out.println("本次SQL关联点：" + param + "  全部关联为： " + correlationMap);
            param.clear();
        }
    }

    public static void main(String[] args) {
        GuanLianSqlTest.addSqlCorrelation("select content,destination,create_time from notify where destination = 18989841226 LIMIT 1 ");
    }
}
