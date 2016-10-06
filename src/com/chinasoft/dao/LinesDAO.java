package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.bean.Lines;

public class LinesDAO extends BaseDAO implements InterfaceLinesDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 获取线路列表
	@Override
	public List<Lines> getList() {
		// TODO Auto-generated method stub
		List<Lines> list = new ArrayList<Lines>();
		con = this.getCon();
		String sql="select * from lines l,hotel h,city c,lineType lt,outType ot where" +
				" l.lineTypeID=lt.lineTypeID and l.outTypeID=ot.outTypeID and l.cityID=c.cityID and " +
				"l.hotelID=h.hotelID";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Lines line = new Lines();
					line.setLineID(rs.getInt("lineID"));
					line.setLineName(rs.getString("lineName"));
					line.setLineTypeTitle(rs.getString("lineTypeTitle"));
					line.setOutTypeTitle(rs.getString("outTypeTitle"));
					line.setHotelName(rs.getString("hotelName"));
					line.setCityName(rs.getString("cityName"));
					line.setBeforePrice(rs.getDouble("beforePrice"));
					line.setNowPrice(rs.getDouble("nowPrice"));
					list.add(line);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		
		return list;
	}

	// 获取某线路的信息
	@Override
	public Lines getLineInfo(String lineid) {
		// TODO Auto-generated method stub
		Lines line = new Lines();
		con = this.getCon();
		String sql="select * from lines l,hotel h,city c,lineType lt,outType ot where" +
				" l.lineTypeID=lt.lineTypeID and l.outTypeID=ot.outTypeID and l.cityID=c.cityID and " +
				"l.hotelID=h.hotelID and lineID="+lineid+"";
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					line.setLineID(rs.getInt("lineID"));
					line.setLineName(rs.getString("lineName"));
					line.setLineTypeTitle(rs.getString("lineTypeTitle"));
					line.setOutTypeTitle(rs.getString("outTypeTitle"));
					line.setHotelName(rs.getString("hotelName"));
					line.setCityName(rs.getString("cityName"));
					line.setBeforePrice(rs.getDouble("beforePrice"));
					line.setNowPrice(rs.getDouble("nowPrice"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return line;
	}

	// 删除线路
	@Override
	public int getDelLine(int lineid) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		String sql="delete from lines where lineID=?";
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, lineid);
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

	// 线路更新
	@Override
	public int getUpdateLine(Lines line) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		
			String sql = "update lines set lineName=?,"
					+"beforePrice=?,"
					+ "outTypeID=(select outTypeID from outType where outTypeTitle=?),"
					+ "nowPrice=?"
					+ " where lineID=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, line.getLineName());
				ps.setDouble(2, line.getBeforePrice());
				ps.setString(3, line.getOutTypeTitle());
				ps.setDouble(4, line.getNowPrice());
				ps.setInt(5, line.getLineID());
				a = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
	
		return a;
	}

	//增加线路
	@Override
	public int getInsertLine(Lines line) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		if(con != null){
			String sql = "insert lines values(?,?,?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, line.getLineName());
				ps.setInt(2, line.getLineTypeID());
				ps.setInt(3, line.getOutTypeID());
				ps.setDouble(4, line.getBeforePrice());
				ps.setDouble(5, line.getNowPrice());
				ps.setDouble(6, line.getCityID());
				ps.setInt(7, line.getHotelID());
				ps.setString(8, line.getPicUrl());
				a=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}

	@Override
	public List<Lines> getList(String linename) {
		// TODO Auto-generated method stub
		List<Lines> list = new ArrayList<Lines>();
		con = this.getCon();
		String sql="select * from lines l,hotel h,city c,lineType lt,outType ot where" +
				" l.lineTypeID=lt.lineTypeID and l.outTypeID=ot.outTypeID and l.cityID=c.cityID and " +
				"l.hotelID=h.hotelID and lineName like ?";
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+linename+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					Lines line = new Lines();
					line.setLineID(rs.getInt("lineID"));
					line.setLineName(rs.getString("lineName"));
					line.setLineTypeTitle(rs.getString("lineTypeTitle"));
					line.setOutTypeTitle(rs.getString("outTypeTitle"));
					line.setHotelName(rs.getString("hotelName"));
					line.setCityName(rs.getString("cityName"));
					line.setBeforePrice(rs.getDouble("beforePrice"));
					line.setNowPrice(rs.getDouble("nowPrice"));
					list.add(line);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return list;
	}

}
