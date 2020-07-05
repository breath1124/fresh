package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanSort;
import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanGoods;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class SortManager {
	
	public static void main(String[] args) throws BaseException {
		// TODO Auto-generated method stub
		DiscountsManager x = new DiscountsManager();
		x.add("test", 10.1, 0.3, "2020-1-1", "2020-12-31");
	}
	
	public BeanSort add_sort(String name, String detail) throws BaseException {
		// TODO Auto-generated method stub
		BeanSort sort = new BeanSort();
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT category_name FROM fresh_sort WHERE category_name = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				if(rs.getString(1).equals(name))
					throw new BaseException("该类别名称已存在");
			sql = "INSERT INTO fresh_sort(category_name,category_detail) VALUES(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, detail);
			pst.execute();
			sort.setCategory_detail(detail);
			sort.setCategory_name(name);
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
		return sort;
	}	

	public void change_category_name(String oldName, String newName) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT category_id, category_name FROM fresh_sort WHERE category_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,newName);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				id = rs.getInt(1);
				if(oldName.equals(rs.getString(2)))	
					throw new BusinessException("已有类别名"+newName+"，请重新修改");
			}
			rs.close();
			pst.close();
			sql="UPDATE fresh_sort SET category_name = ? WHERE category_name = ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,newName);
			pst.setString(2, oldName);
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
	
	public void change_category_detail(String name, String newDetail) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
//		int id = sort.getCategory_id();
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT category_name FROM fresh_sort WHERE category_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("没有此类别");
			sql="UPDATE fresh_sort SET category_detail = ? WHERE category_name = ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,newDetail);
			pst.setString(2, name);
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
	
	public BeanSort find_category(String name) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		BeanSort sort = new BeanSort();
		sort.setCategory_name(name);
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT category_id, category_detail FROM fresh_sort WHERE category_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				sort.setCategory_id(rs.getInt(1));
				sort.setCategory_detail(rs.getString(2));
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
		return sort;
	}
	
	public void del_sort(String name) throws BaseException {
		// TODO Auto-generated method stub
		String pass = null;
		int id = 0;
		int cnt = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT category_id FROM fresh_sort WHERE category_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BusinessException("没有此类别无法删除");
			pst.close();
			rs.close();
			sql = "SELECT COUNT(goods_id) FROM fresh_goods WHERE category_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next())
				cnt = rs.getInt(1);
			if(cnt > 0)
				throw new BusinessException("类别中含有商品无法删除");
			pst.close();
			rs.close();
			sql = "DELETE FROM fresh_sort WHERE category_name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
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
