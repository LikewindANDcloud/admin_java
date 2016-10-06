package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {

	// 驱动
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// URL
	private final String URL = "jdbc:sqlserver://localhost:1433;DataBaseName = JSPTravel";
	// 用户名
	private final String USER = "sa";
	// 密码
	private final String PWD = "324sunrise";

	// 数据库连接
	public Connection getCon() {
		Connection con = null;
		try {
			// 加载驱动
			Class.forName(DRIVER);
			// 连接
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	// 数据库关闭
	public void getClose(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
