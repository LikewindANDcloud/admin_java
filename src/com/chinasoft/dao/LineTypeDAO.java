package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LineTypeDAO extends BaseDAO implements InterLineTypeDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int getTypeID(String TypeTitle) {
		// TODO Auto-generated method stub
		con = this.getCon();
		int typeid = 0;
		if (con != null) {
			String sql = "select lineTypeID from lineType where lineTypeTitle = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, TypeTitle);
				rs = ps.executeQuery();
				if (rs.next()) {
					typeid = rs.getInt("lineTypeID");
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
