package WanZheng.java.utils.jdbc;

import java.sql.SQLException;
import java.util.List;

import C3P0.DbUser;
import WanZheng.java.utils.httpclient.TestCase;
import WanZheng.java.utils.httpclient.check.CheckPointUtils;
import WanZheng.java.utils.httpclient.check.JsonCheckResult;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;



public class DbCheck {
	
	public static String check(TestCase testcase) {
		if(StringUtils.isEmpty(testcase.getDbchecksql())||StringUtils.isEmpty(testcase.getDbcheckpoint())) {
			return "无数据库检查点";
		}
		String sql =testcase.getDbchecksql();
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			System.out.println("检查语句： "+sql+" 检查点 "+testcase.getDbcheckpoint());
			Object map = runner.query(sql, new MapHandler());
			String json=JSON.toJSONString(map);
			System.out.println(json);
			JsonCheckResult jsonCheckResult = CheckPointUtils.check(json, testcase.getDbcheckpoint());
			if(jsonCheckResult.isResult()) {
				return "数据库检查成功";
			}else {
				return "数据库检查失败";	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "检查点异常";
	}

}
