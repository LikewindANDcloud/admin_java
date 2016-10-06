package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasoft.bean.Admin;

public class AdminDAO extends BaseDAO implements InterfaceAdminDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// µÇÂ¼
	@Override
	public Admin getLogin(String adminname,String adminpwd) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		con = this.getCon();
		String sql="select * from admin where adminNumber=? and adminPwd=?";
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, adminname);
				ps.setString(2, adminpwd);
				rs = ps.executeQuery();
				if (rs.next()) {
					admin.setAdminID(rs.getInt("adminID"));
					admin.setAdminNumber(rs.getString("adminNumber"));
					admin.setAdminPwd(rs.getString("adminPwd"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}

		}
		return admin;
	}

	// ¸üÐÂÃÜÂë
	@Override
	public int getUpdate(String sql) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				a = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return a;
	}

}
