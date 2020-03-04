package WanZheng.java.utils.correlation;

import C3P0.JDBCUtils;
import WanZheng.java.utils.httpclient.TestCase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.lang3.StringUtils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理数据关联类
 *
 * @author pc
 */
public class CorrelationUtils {
    private static Map<String, Object> correlationMap = new LinkedHashMap<String, Object>();
    private static String sqlreturn;

    private static Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");        //关联时使用 ${变量} 来判断关联的变量

    public static void clear() {
        if (correlationMap != null) {
            correlationMap.clear();
        }
    }

    /**
     * 对象属性和值反射到关联map
     *
     * @param o
     */
    public static void addCorrelation(Object o) {
        Class class1 = o.getClass();
        Field[] filFields = class1.getDeclaredFields();
        for (Field field : filFields) {
            String name = field.getName();
            try {
                String value = BeanUtils.getProperty(o, name);
                correlationMap.put(name, value);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        System.out.println("correlationMap " + correlationMap);
    }

    public static void addSqlCorrelation(TestCase testcase) {

        if (testcase.getSqlCorrelation() != null) {                          //如果excel数据库检查点不为空，则运行下面代码
            Map sqlreturnM;
            QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());          //dbutils实例化查询，准备执行查询SQL语句
            try {
                sqlreturnM = runner.query(testcase.getSqlCorrelation(), new MapHandler()); //BeanListHandler可以选择list，map
                sqlreturn = sqlreturnM.toString();                    //因为SQL返回的数据带大括号，所以改成String类型去掉大括号
                sqlreturn = sqlreturn.replaceAll("\\{|\\}", "").replace(", ", ",");   //去掉大括号并把”逗号+空格“替换为”逗号“
                System.out.println(sqlreturn);                        //输出SQL返回的结果（去掉了无用的符号）
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Map<String, Object> param = MapUtils.covertStringToMap3(sqlreturn);    //得到excel文件中检查点下的数据,covertStringToMap3是使用逗号分隔的方法
            if (param != null) {
                Set<String> keys = param.keySet();                                 //通过Map.keySet获取key值，param是上面数据库返回的数据转换成的map集合
                for (String data : keys) {                                        //把map中的所有key写入到变量data中
                    Object object = (param.get(data).toString());                 //通过写入的key提取value，写入object（此时data代表map中获取的key，object代表value）
                    //如果提取的是多个数据
                    if (object instanceof List) {
                        int i = 0;
                        List<Object> list = (List<Object>) object;
                        for (Object object_item : list) {
                            correlationMap.put(data + "_g" + (++i), object_item);
                        }
                    } else {
                        //如果提取的是单个数据
                        correlationMap.put(data, (param.get(data).toString()));   //将key和value写入correlationMap中，成为新的map集合
                    }
                }
                System.out.println("本次SQL关联点：" + param + "  全部关联为： " + correlationMap);
                param.clear();
            }
        }

    }

    /**
     * 把返回值提取到全局correlationMap
     *
     * @param testcase
     */
    public static void addCorrelation(String result, TestCase testcase) {
        if (!JSON.isValid(result)) {        //如果获取到的接口返回值不是json类型，就不允许此方法
            return;
        }
        //先分析字段
        Map<String, Object> param = MapUtils.covertStringToMap(testcase.getCorrelation());    //得到excel文件中检查点下的数据
        if (param != null) {
            Set<String> keys = param.keySet();                              //和上面数据库关联一样，先把excel获取到的转换成map，然后获取key和value形成新map，完成关联
            //把技术翻译成业务支持
            for (String key : keys) {
                Object object = JSONPath.read(result, param.get(key).toString());
                //如果提取的是多个数据
                if (object instanceof List) {
                    int i = 0;
                    List<Object> list = (List<Object>) object;
                    for (Object object_item : list) {
                        correlationMap.put(key + "_g" + (++i), object_item);
                    }
                } else {
                    //如果提取的是单个数据
                    correlationMap.put(key, JSONPath.read(result, param.get(key).toString()));   //关联多个用 ; 分隔
                }
            }
            System.out.println("本次excel关联点：" + param + "  全部关联为： " + correlationMap);
            param.clear();
        }
    }


    private static Object getCorrelationValue(String key) {
        Object value = correlationMap.get(key);
        if (value == null) {
            return "";
        }
        return value;
    }

    /**
     * 前置替换
     *
     * @param testcase
     */
    public static void doBefore_replace(TestCase testcase) {
        //检查url 关联
        testcase.setUrl(getPatternValue(testcase.getUrl()));

        //检查替换头部 关联
        testcase.setHeader(getPatternValue(testcase.getHeader()));

        //检查替换body 关联
        testcase.setParams(getPatternValue(testcase.getParams()));

    }

    /**
     * 后置关联提取
     *
     * @param testcase
     */
    public static void doafter_replace(TestCase testcase) {
        //sql 特殊处理下 单引号问题
        testcase.setDbchecksql(getPatternWithString(testcase.getDbchecksql()));

        testcase.setDbcheckpoint(getPatternValue(testcase.getDbcheckpoint()));
    }

    /**
     * 判断字符串是否满足替换条件，并替换
     *
     * @param str
     * @return
     */
    private static String getPatternValue(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
//	        	System.out.println(matcher.group());
//	        	System.out.println("----------");
//	        	System.out.println(matcher.group(1));
            str = str.replace(matcher.group(), getCorrelationValue(matcher.group(1)).toString());
        }
        return str;

    }

    /**
     * 特殊关联数据需要加单引号
     *
     * @param str
     * @return
     */
    private static String getPatternWithString(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
//	        	System.out.println(matcher.group());
//	        	System.out.println("----------");
//	        	System.out.println(matcher.group(1));
            Object object = getCorrelationValue(matcher.group(1));
            if (object instanceof String) {
                String str_object = object.toString();
                str_object = "'" + str_object + "'";
                str = str.replace(matcher.group(), str_object);
            } else {
                str = str.replace(matcher.group(), object.toString());
            }

        }
        return str;

    }

}
