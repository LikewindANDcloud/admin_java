package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.chinasoft.bean.Users;

public class UsersDAO extends BaseDAO implements InterfaceUsersDAO {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 用户表列表
	@Override
	public List<Users> getList(String sql) {
		// TODO Auto-generated method stub
		List<Users> list = new ArrayList<Users>();
		// 连接数据库
		con = this.getCon();
		
		// 验证是否连接成功
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Users user = new Users();
					user.setUserID(rs.getInt("userID"));
					user.setUserNumber(rs.getString("userNumber"));
					user.setUserPwd(rs.getString("userPwd"));
					user.setUserName(rs.getString("userName"));
					user.setUserIdentity(rs.getString("userIdentity"));
					user.setUserTel(rs.getString("userTel"));
					user.setUserSex(rs.getString("userSex"));
					user.setUserVipTitle(rs.getString("vipTitle"));
					user.setOrderNum(rs.getInt("订单量"));
					list.add(user);
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

	// 用户表数据总数
	@Override
	public int getUDataCount(String sql) {
		// TODO Auto-generated method stub
		int ucount = 0;
		// 连接数据库
		con = this.getCon();
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					ucount = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return ucount;
	}

	// 后台进行用户删除
	@Override
	public int getDelUsers(String sql) {
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

	// 用户信息更新
	@Override
	public int getUpdateUsers(Users user) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "update users set userNumber=?,userPwd=?,userName=?,userTel=?,userIdentity=?,userSex=?,vipID=? where userID=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, user.getUserNumber());
				ps.setString(2, user.getUserPwd());
				ps.setString(3, user.getUserName());
				ps.setString(4, user.getUserTel());
				ps.setString(5, user.getUserIdentity());
				ps.setString(6, user.getUserSex());
				ps.setInt(7, user.getVipID());
				ps.setInt(8, user.getUserID());
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

	// 查找用户
	@Override
	public boolean getFind(String sql) {
		// TODO Auto-generated method stub
		boolean isFind = false;
		con = this.getCon();
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					isFind = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return isFind;
	}

	// 注册
	@Override
	public int getRegUsers(Users user) {
		// TODO Auto-generated method stub
		int a = 0;
		con = this.getCon();
		if (con != null) {
			String sql = "insert users values(?,?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, user.getUserNumber());
				ps.setString(2, user.getUserPwd());
				ps.setString(3, user.getUserName());
				ps.setString(4, user.getUserTel());
				ps.setString(5, user.getUserIdentity());
				ps.setString(6, user.getUserSex());
				ps.setInt(7, user.getVipID());
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
	public Users getLogin(String sql) {
		// TODO Auto-generated method stub
		Users user = new Users();
		con = this.getCon();
		if (con != null) {
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					user.setUserID(rs.getInt("userID"));
					user.setUserNumber(rs.getString("userNumber"));
					user.setUserPwd(rs.getString("userPwd"));
					user.setUserName(rs.getString("userName"));
					user.setUserTel(rs.getString("userTel"));
					user.setUserIdentity(rs.getString("userIdentity"));
					user.setUserSex(rs.getString("userSex"));
					user.setVipID(rs.getInt("vipID"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.getClose(rs, ps, con);
			}
		}
		return user;
	}

	@Override
	public int updateUsers(int userId,int vipId) {
		// TODO Auto-generated method stub
		int a=0;
		con=this.getCon();
		String sql="update users set vipID=? where userID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, vipId);
			ps.setInt(2, userId);
			a=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int getOrderNumById(int userId) {
		// TODO Auto-generated method stub
		int a=0;
		con=this.getCon();
		String sql="select * from users u,vipTitle v, (select users.userID, count(*) 订单量 from users,orders where users.userID=orders.userID group by users.userID) a where u.userID=a.userID and u.vipID=v.vipID and u.userID=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			if(rs.next()){
				a=rs.getInt("订单量");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	

}
