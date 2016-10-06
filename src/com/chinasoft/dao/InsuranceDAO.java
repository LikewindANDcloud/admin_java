package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.bean.Insurance;

public class InsuranceDAO extends BaseDAO implements InterfaceInsuranceDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Insurance> getList(String sql) {
		// TODO Auto-generated method stub
		List<Insurance> list = new ArrayList<Insurance>();
		con = this.getCon();
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Insurance ins = new Insurance();
					ins.setInsuranceID(rs.getInt("insuranceID"));
					ins.setInsuranceName(rs.getString("insuranceName"));
					ins.setInsuranceMoney(rs.getDouble("insuranceMoney"));
					list.add(ins);
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

	@Override
	public int getInsert(Insurance ins) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "insert insurance values(?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, ins.getInsuranceName());
				ps.setDouble(2, ins.getInsuranceMoney());
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

	@Override
	public int getDel(String sql) {
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

	@Override
	public int getUpdate(Insurance ins) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "update insurance set insuranceName = "
					+ ins.getInsuranceName() + " and insuranceMoney = "
					+ ins.getInsuranceMoney();
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

	@Override
	public int getInsurId(String insurname) {
		// TODO Auto-generated method stub
		int a=0;
		con=this.getCon();
		String sql="select * from insurance where insuranceName=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, insurname);
			rs=ps.executeQuery();
			if(rs.next()){
				a=rs.getInt("insuranceID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
