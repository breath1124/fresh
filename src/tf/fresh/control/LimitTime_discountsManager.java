package tf.fresh.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanDiscounts;
import tf.fresh.model.BeanLimitTime_discounts;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class LimitTime_discountsManager {
	public BeanLimitTime_discounts add(int goods_id, double pro_price, int pro_cnt, String begin, String end) throws BaseException {
		// TODO Auto-generated method stub
		BeanLimitTime_discounts limit = new BeanLimitTime_discounts();
		int id = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select goods_id from fresh_goods where goods_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, goods_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("该商品不存在");
			rs.close();
			pst.close();
			sql = "INSERT INTO fresh_limitTime_discounts VALUES (?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goods_id);
			pst.setDouble(2, pro_price);
			pst.setInt(3, pro_cnt);
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
		return limit;
	}
	
	public BeanLimitTime_discounts find(int pro_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanLimitTime_discounts limit = new BeanLimitTime_discounts();
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT promotion_id FROM fresh_limittime_discounts WHERE promotion_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pro_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此促销");
			pst.close();
			rs.close();
			sql = "SELECT promotion_id, goods_id, promotion_price, promotion_cnt, promotion_begin, promotion_end"
					+ " FROM fresh_limittime_discounts WHERE promotion_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pro_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				limit.setPromotion_id(rs.getInt(1));
				limit.setGoods_id(rs.getInt(2));
				limit.setPromotion_price(rs.getDouble(3));
				limit.setPromotion_cnt(rs.getInt(4));
				limit.setPromotion_begin(rs.getDate(5));
				limit.setPromotion_end(rs.getDate(6));
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
		return limit;
	}	
	
	public void modify(int pro_id, int goods_id, double pro_price, int pro_cnt, String begin, String end) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT promotion_id FROM fresh_limittime_discounts WHERE promotion_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pro_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此促销");
			pst.close();
			rs.close();
			sql = "UPDATE fresh_limittime_discounts SET goods_id = ?, promotion_price = ?, promotion_cnt = ?, "
					+ "promotion_begin = ?, promotion_end = ? WHERE promotion_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goods_id);
			pst.setDouble(2, pro_price);
			pst.setInt(3, pro_cnt);
			pst.setString(4, begin);
			pst.setString(5, end);
			pst.setInt(6, pro_id);
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
	
	public void del(int pro_id) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT promotion_id FROM fresh_limittime_discounts WHERE promotion_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, pro_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此促销");
			pst.close();
			rs.close();
			sql = "DELETE FROM fresh_limittime_discounts WHERE promotion_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pro_id);
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
