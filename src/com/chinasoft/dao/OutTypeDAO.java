package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutTypeDAO extends BaseDAO implements InterOutTypeDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int getOutTypeID(String TypeTitle) {
		// TODO Auto-generated method stub
		int typeid = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "select outTypeID from outType where outTypeTitle = ?"	;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1,TypeTitle);
				rs = ps.executeQuery();
				if (rs.next()) {
					typeid = rs.getInt("outTypeID");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return typeid;
	}

}
