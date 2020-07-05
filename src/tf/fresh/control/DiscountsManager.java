package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanDiscounts;
import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanGoods;
import tf.fresh.model.BeanSort;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class DiscountsManager {
	public BeanDiscounts add(String detail, double suitMoney, double minuMoney, String begin, String end) throws BaseException {
		// TODO Auto-generated method stub
		BeanDiscounts discounts = new BeanDiscounts();
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "INSERT INTO fresh_discounts(discnt_detail,discnt_suitMoney,discnt_minuMoney,discnt_begin,discnt_end) VALUES(?,?,?,?,?)";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, detail);
			pst.setDouble(2, suitMoney);
			pst.setDouble(3, minuMoney);
			pst.setString(4, begin);
			pst.setString(5, end);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return discounts;
	}	
	
	public BeanDiscounts find(int discnt_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanDiscounts discounts = new BeanDiscounts();
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT discnt_id FROM fresh_discounts WHERE discnt_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, discnt_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此优惠券");
			pst.close();
			rs.close();
			sql = "SELECT discnt_detail,discnt_suitMoney,discnt_minuMoney,discnt_begin,discnt_end FROM fresh_discounts WHERE discnt_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, discnt_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				discounts.setDiscnt_id(discnt_id);
				discounts.setDiscnt_detail(rs.getString(1));
				discounts.setDiscnt_suitMoney(rs.getDouble(2));
				discounts.setDiscnt_minuMoney(rs.getDouble(3));
				discounts.setDiscnt_begin(rs.getDate(4));
				discounts.setDiscnt_end(rs.getDate(5)); 	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return discounts;
	}	
	
	public void modify(int discnt_id, String discnt_detail, double discnt_suitMoney, 
			double discnt_minuMoney, String discnt_begin, String discnt_end) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT discnt_id FROM fresh_discounts WHERE discnt_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, discnt_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此优惠券");
			pst.close();
			rs.close();
			sql = "UPDATE fresh_discounts SET discnt_detail = ?,discnt_suitMoney = ?,"
					+ "discnt_minuMoney = ?,discnt_begin = ?,discnt_end = ? WHERE discnt_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, discnt_detail);
			pst.setDouble(2, discnt_suitMoney);
			pst.setDouble(3, discnt_minuMoney);
			pst.setString(4, discnt_begin);
			pst.setString(5, discnt_end);
			pst.setInt(6, discnt_id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}	
	
	public void del(int discnt_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT discnt_id FROM fresh_discounts WHERE discnt_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, discnt_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此优惠券");
			pst.close();
			rs.close();
			sql = "DELETE FROM fresh_discounts WHERE discnt_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, discnt_id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
}
