package C3P0;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.UUID;

public class AddDataToDB {

	public static final String URL = "jdbc:mysql://192.168.1.150:3306/test?";
	public static final String USER = "attest";
	public static final String PASSWORD = "attest123";

	private static Connection getConn() {
//		// 1 获取驱动
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			// 2.获得数据库连接
//			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			return conn;
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
		
		//连接池改造
		try {
			return JDBCUtils.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void add(String loginname, String loginpass) {
		System.out.println("add " + loginname + " " + loginpass);
		Connection conn = getConn();
		// sql
		String sql = "INSERT INTO t_user_test(uid, loginname, loginpass) values(?,?,?)"; //先写成问好，然后在方法传值，可以保证安全性，值不容易被抓到
		// 预编译
		try {
			// 预编译SQL，减少sql执行，可以检测安全问题
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, UUID.randomUUID().toString());
			ptmt.setString(2, loginname);
			ptmt.setString(3, loginpass);
			// 执行
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void delete() {
		System.out.println("delete ");
		 //获取连接
        Connection conn = getConn();
        //sql, 每行加空格
        String sql = "delete from user";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			 //执行
	        ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

       
	}

	public static void main(String[] args) {
		delete();
		for (int i = 0; i < 10000; i++) {
			AddDataToDB.add("test" + i, "pass" + i);
		}

	}

}
