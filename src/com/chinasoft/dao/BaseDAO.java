package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {

	// ����
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// URL
	private final String URL = "jdbc:sqlserver://localhost:1433;DataBaseName = JSPTravel";
	// �û���
	private final String USER = "sa";
	// ����
	private final String PWD = "324sunrise";

	// ���ݿ�����
	public Connection getCon() {
		Connection con = null;
		try {
			// ��������
			Class.forName(DRIVER);
			// ����
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	// ���ݿ�ر�
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
