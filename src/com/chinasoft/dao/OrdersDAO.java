package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.bean.Orders;

public class OrdersDAO extends BaseDAO implements InterfaceOrdersDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Orders> getList() {
		// TODO Auto-generated method stub
		List<Orders> list = new ArrayList<Orders>();
		con = this.getCon();
		String sql="SELECT * FROM  dbo.insurance INNER JOIN "+
                "dbo.orders ON dbo.insurance.insuranceID = dbo.orders.insuranceID INNER JOIN "+
                "dbo.lines ON dbo.orders.lineID = dbo.lines.lineID INNER JOIN "+
                "dbo.users ON dbo.orders.userID = dbo.users.userID";
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Orders ord = new Orders();
					ord.setOrderID(rs.getInt("orderID"));
					ord.setLineID(rs.getInt("lineID"));
					ord.setLineName(rs.getString("lineName"));
					ord.setUserID(rs.getInt("userID"));
					ord.setUserName(rs.getString("userName"));
					ord.setOutDate(rs.getString("outDate"));
					ord.setSumPerson(rs.getInt("sumPerson"));
					ord.setReturnDate(rs.getString("returnDate"));
					ord.setInsuranceID(rs.getInt("insuranceID"));
					ord.setInsuranceName(rs.getString("insuranceName"));
					ord.setSumPrice(rs.getDouble("sumPrice"));
					ord.setFinalPrice(rs.getDouble("finalPrice"));
					ord.setOrderTime(rs.getString("orderTime"));
					list.add(ord);
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
	public int getDel(int orderid) {
		// TODO Auto-generated method stub
		int a = 0;
		String sql="delete from orders where orderID=?";
		con = this.getCon();
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, orderid);
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
	public int getInsert(Orders ord) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "insert orders values(?,?,?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, ord.getLineID());
				ps.setInt(2, ord.getUserID());
				ps.setString(3, ord.getOutDate());
				ps.setString(4, ord.getReturnDate());
				ps.setInt(5, ord.getInsuranceID());
				ps.setDouble(6, ord.getSumPrice());
				ps.setDouble(7, ord.getFinalPrice());
				ps.setString(8, ord.getOrderTime());
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
	public Orders getOrderById(int orderId) {
		// TODO Auto-generated method stub
		Orders ord=new Orders();
		con = this.getCon();
		String sql="SELECT * FROM  dbo.insurance INNER JOIN "+
                "dbo.orders ON dbo.insurance.insuranceID = dbo.orders.insuranceID INNER JOIN "+
                "dbo.lines ON dbo.orders.lineID = dbo.lines.lineID INNER JOIN "+
                "dbo.users ON dbo.orders.userID = dbo.users.userID AND orderID=?";
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, orderId);
				rs = ps.executeQuery();
				if (rs.next()) {
					ord.setOrderID(rs.getInt("orderID"));
					ord.setLineID(rs.getInt("lineID"));
					ord.setLineName(rs.getString("lineName"));
					ord.setUserID(rs.getInt("userID"));
					ord.setUserName(rs.getString("userName"));
					ord.setOutDate(rs.getString("outDate"));
					ord.setSumPerson(rs.getInt("sumPerson"));
					ord.setReturnDate(rs.getString("returnDate"));
					ord.setInsuranceID(rs.getInt("insuranceID"));
					ord.setInsuranceName(rs.getString("insuranceName"));
					ord.setSumPrice(rs.getDouble("sumPrice"));
					ord.setFinalPrice(rs.getDouble("finalPrice"));
					ord.setOrderTime(rs.getString("orderTime"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return ord;
	}

	@Override
	public int updateOrder(Orders ord) {
		// TODO Auto-generated method stub
		int a=0;
		con=this.getCon();
		String sql="update orders set insuranceID=?,sumPerson=?,sumPrice=?,finalPrice=? where orderID=?";
		if(con!=null){
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, ord.getInsuranceID());
				ps.setInt(2, ord.getSumPerson());
				ps.setDouble(3, ord.getSumPrice());
				ps.setDouble(4, ord.getFinalPrice());
				ps.setInt(5, ord.getOrderID());
				a=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}

	@Override
	public List<Orders> getOrderByUserName(String userName) {
		// TODO Auto-generated method stub
		List<Orders> list = new ArrayList<Orders>();
		con = this.getCon();
		String sql="SELECT * FROM  dbo.insurance INNER JOIN "+
                "dbo.orders ON dbo.insurance.insuranceID = dbo.orders.insuranceID INNER JOIN "+
                "dbo.lines ON dbo.orders.lineID = dbo.lines.lineID INNER JOIN "+
                "dbo.users ON dbo.orders.userID = dbo.users.userID AND dbo.users.userName like ?";
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+userName+"%");
				rs = ps.executeQuery();
				while (rs.next()) {
					Orders ord = new Orders();
					ord.setOrderID(rs.getInt("orderID"));
					ord.setLineID(rs.getInt("lineID"));
					ord.setLineName(rs.getString("lineName"));
					ord.setUserID(rs.getInt("userID"));
					ord.setUserName(rs.getString("userName"));
					ord.setOutDate(rs.getString("outDate"));
					ord.setSumPerson(rs.getInt("sumPerson"));
					ord.setReturnDate(rs.getString("returnDate"));
					ord.setInsuranceID(rs.getInt("insuranceID"));
					ord.setInsuranceName(rs.getString("insuranceName"));
					ord.setSumPrice(rs.getDouble("sumPrice"));
					ord.setFinalPrice(rs.getDouble("finalPrice"));
					ord.setOrderTime(rs.getString("orderTime"));
					list.add(ord);
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
