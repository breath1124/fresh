package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanFullrelations_info;
import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanFulldiscounts_info;
import tf.fresh.model.BeanGoods;
import tf.fresh.model.BeanSort;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class FullRelations_infoManager {
	public BeanFullrelations_info add(int full_id, int goods_id, String begin, String end) throws BaseException {
		// TODO Auto-generated method stub
		BeanFullrelations_info rela_info = new BeanFullrelations_info();
		Connection conn = null;
		int cnt = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM fresh_fullrelation_goods WHERE full_id = ? AND goods_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			pst.setInt(2, goods_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				cnt = rs.getInt(1);
			if(cnt > 0)
				throw new BaseException("已有此满折商品关联");
			pst.close();
			rs.close();
			sql = "INSERT INTO fresh_fullrelation_goods(full_id,goods_id,discnt_begin,discnt_end) VALUES(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			pst.setInt(2, goods_id);
			pst.setString(3, begin);
			pst.setString(4, end);
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
		return rela_info;
	}	
	
	public BeanFullrelations_info find(int full_id, int goods_id) throws BaseException {
		BeanFullrelations_info rela_info = new BeanFullrelations_info();
		Connection conn = null;
		int cnt = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM fresh_fullrelation_goods WHERE full_id = ? AND goods_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			pst.setInt(2, goods_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				cnt = rs.getInt(1);
			if(cnt == 0)
				throw new BaseException("没有此满折商品关联");
			pst.close();
			rs.close();
			sql = "SELECT discnt_begin,discnt_end FROM fresh_fullrelation_goods WHERE full_id = ? AND goods_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			pst.setInt(2, goods_id);
			rs = pst.executeQuery();
			if(rs.next())
			{
				rela_info.setFull_id(full_id);
				rela_info.setGoods_id(goods_id);
				rela_info.setDiscnt_begin(rs.getDate(1));
				rela_info.setDiscnt_end(rs.getDate(2));
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
		return rela_info;
	}	
	
	public void modify(int oldfull_id, int oldgoods_id, int newfull_id, int newgoods_id,
			String discnt_begin, String discnt_end) throws BaseException {
		BeanFullrelations_info rela_info = new BeanFullrelations_info();
		Connection conn = null;
		int cnt = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM fresh_fullrelation_goods WHERE full_id = ? AND goods_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, newfull_id);
			pst.setInt(2, newgoods_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				cnt = rs.getInt(1);
			if(cnt > 0)
				throw new BaseException("存在将要修改的新的满折商品关联，请重新修改");
			pst.close();
			rs.close();
			sql = "UPDATE FROM fresh_fullrelation_goods SET full_id = ?, goods_id = ?, discnt_begin = ?, discnt_end = ? "
					+ "WHERE full_id = ? AND goods_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, newfull_id);
			pst.setInt(2, newgoods_id);
			pst.setString(3, discnt_begin);
			pst.setString(4, discnt_end);
			pst.setInt(5, oldfull_id);
			pst.setInt(6, oldgoods_id);
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
	
	public void del(int full_id, int goods_id) throws BaseException {
		BeanFullrelations_info rela_info = new BeanFullrelations_info();
		Connection conn = null;
		int cnt = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM fresh_fullrelation_goods WHERE full_id = ? AND goods_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			pst.setInt(2, goods_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				cnt = rs.getInt(1);
			if(cnt == 0)
				throw new BaseException("没有此满折商品关联，无法删除");
			pst.close();
			rs.close();
			sql = "DELETE FROM fresh_fullrelation_goods WHERE full_id = ? AND goods_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, newfull_id);
			pst.setInt(2, newgoods_id);
			pst.setString(3, discnt_begin);
			pst.setString(4, discnt_end);
			pst.setInt(5, oldfull_id);
			pst.setInt(6, oldgoods_id);
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
