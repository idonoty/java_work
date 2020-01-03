package WanZheng.java.utils.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;



public class DbUtilsTest {
	
	public static void main(String[] args) {
		   QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	        String sql = "select * from user";
			try {
				List list = (List) runner.query(sql, new BeanListHandler(DbUser.class));
				System.out.println(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	       

	}

}
