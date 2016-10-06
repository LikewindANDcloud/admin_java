package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDAO extends BaseDAO implements InterHotelDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int getHotelID(String HotelName) {
		// TODO Auto-generated method stub
		int hotelid = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "select hotelID from hotel where hotelName = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, HotelName);
				rs = ps.executeQuery();
				if(rs.next()){
					hotelid = rs.getInt("hotelID");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return hotelid;
	}

	@Override
	public int getCityID(String HotelName) {
		// TODO Auto-generated method stub
		int cityid = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "select cityID from hotel where hotelName = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, HotelName);
				rs = ps.executeQuery();
				if(rs.next()){
					cityid = rs.getInt("cityID");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return cityid;
	}

}
