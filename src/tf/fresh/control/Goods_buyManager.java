package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanGoods_buy;
import tf.fresh.model.BeanSort;
import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanGoods;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class Goods_buyManager {
	public BeanGoods_buy add(String staff_id, int goods_id, int buy_cnt, String buy_state) throws BaseException {
		// TODO Auto-generated method stub
		BeanGoods_buy good_buy = new BeanGoods_buy();
		int id1 = 0;
		String id2 = null;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT goods_id FROM fresh_goods WHERE goods_id = ?";	
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, goods_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id1 = rs.getInt(1);
			if(id1 == 0)
				throw new BaseException("无此商品号");
			pst.close();
			rs.close();
			sql = "SELECT staff_id FROM fresh_admin WHERE staff_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, staff_id);
			rs = pst.executeQuery();
			if(rs.next())
				id2 = rs.getString(1);
			if(id2 == null)
				throw new BaseException("无此员工号");
			pst.close();
			rs.close();
			sql = "INSERT INTO fresh_goods_buy(staff_id,goods_id,buy_cnt,buy_state) VALUES(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, staff_id);
			pst.setInt(2, goods_id);
			pst.setInt(3, buy_cnt);
			pst.setString(4, buy_state);
			pst.execute();
			pst.close();
			good_buy.setBuy_cnt(buy_cnt);
			good_buy.setBuy_state(buy_state);
			good_buy.setGoods_id(goods_id);
			good_buy.setStaff_id(staff_id);
			
			if(buy_state.equals("入库"))
			{
				sql = "UPDATE fresh_goods SET goods_count = goods_count + ? WHERE goods_id = ?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, buy_cnt);
				pst.setInt(2, goods_id);
				pst.execute();
				pst.close();				
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
		return good_buy;
	}
	
	public BeanGoods_buy find(int buy_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanGoods_buy good_buy = new BeanGoods_buy();
		int id = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT buyid FROM fresh_goods_buy WHERE buy_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, buy_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此订单号");			
			pst.close();
			rs.close();
			sql = "SELECT staff_id, goods_id, buy_cnt, buy_state FROM fresh_goods_buy WHERE buy_id = ?";	
			pst = conn.prepareStatement(sql);
			pst.setInt(1, buy_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				good_buy.setBuy_id(buy_id);
				good_buy.setStaff_id(rs.getString(1));
				good_buy.setGoods_id(rs.getInt(2));
				good_buy.setBuy_cnt(rs.getInt(3));
				good_buy.setBuy_state(rs.getString(4));
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
		return good_buy;
	}
	
	public void modify(int buy_id, String state) throws BaseException {
		// TODO Auto-generated method stub
		BeanGoods_buy good_buy = new BeanGoods_buy();
		int id = 0;
		int goods_id = 0;
		int buy_cnt = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT buy_id, goods_id, buy_cnt FROM fresh_goods_buy WHERE buy_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, buy_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此订单号");			
			goods_id = rs.getInt(2);
			buy_cnt = rs.getInt(3);
			pst.close();
			rs.close();
			sql = "UPDATE fresh_goods_buy  SET buy_state = ? WHERE buy_id = ?";	
			pst = conn.prepareStatement(sql);
			pst.setString(1, state);
			pst.setInt(2, buy_id);
			pst.execute();
			if(state.equals("入库"))
			{
				sql = "UPDATE fresh_goods SET goods_count = goods_count + ? WHERE goods_id = ?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, buy_cnt);
				pst.setInt(2, goods_id);
				pst.execute();
				pst.close();				
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
	}
	
}
