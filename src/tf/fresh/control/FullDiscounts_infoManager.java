package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanFulldiscounts_info;
import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanGoods;
import tf.fresh.model.BeanSort;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class FullDiscounts_infoManager {
	public BeanFulldiscounts_info add(String detail, int suitCnt, double disCnt, String begin, String end) throws BaseException {
		// TODO Auto-generated method stub
		BeanFulldiscounts_info full_info = new BeanFulldiscounts_info();
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "INSERT INTO fresh_fulldiscounts_info(full_detail,full_suitCnt,full_disCnt,full_begin,full_end) VALUES(?,?,?,?,?)";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, detail);
			pst.setInt(2, suitCnt);
			pst.setDouble(3, disCnt);
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
		return full_info;
	}	
	
	public BeanFulldiscounts_info find(int full_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanFulldiscounts_info full_info = new BeanFulldiscounts_info();
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT full_id,full_detail,full_suitCnt,full_disCnt,full_begin,full_end FROM fresh_fulldiscounts_info WHERE full_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此满折活动");
			full_info.setFull_id(full_id);
			full_info.setFull_detail(rs.getString(2));
			full_info.setFull_suitCnt(rs.getInt(3));
			full_info.setDiscnt(rs.getDouble(4));
			full_info.setFull_begin(rs.getDate(5));
			full_info.setFull_end(rs.getDate(6));
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
		return full_info;
	}	
	
	public void modify(int full_id, String detail, int suitCnt, double disCnt, String begin, String end) throws BaseException {
		// TODO Auto-generated method stub
		BeanFulldiscounts_info full_info = new BeanFulldiscounts_info();
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT full_id FROM fresh_fulldiscounts_info WHERE full_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此满折活动");
			pst.close();
			rs.close();
			sql = "UPDATE fresh_fulldiscounts_info SET full_detail = ?, full_suitCnt = ?, full_disCnt = ?， full_begin = ?, full_end = ? WHERE full_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, detail);
			pst.setInt(2, suitCnt);
			pst.setDouble(3,disCnt);
			pst.setString(4, begin);
			pst.setString(5, end);
			pst.setInt(6, full_id);
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
	
	public void del(int full_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanFulldiscounts_info full_info = new BeanFulldiscounts_info();
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT full_id FROM fresh_fulldiscounts_info WHERE full_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此满折活动");
			pst.close();
			rs.close();
			sql = "DELETE FROM fresh_fulldiscounts_info WHERE full_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, full_id);
			pst.execute();
			pst.close();
			sql = "DELETE FROM fresh_fullrelation_goods WHERE full_id = ?";      //这里也不确定写一起删除还是无法删除
			pst.setInt(1, full_id);
			pst.execute();
			pst.close();
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
