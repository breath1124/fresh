package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanRecRecp;
import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanDiscounts;
import tf.fresh.model.BeanGoods;
import tf.fresh.model.BeanSort;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class RecRecpManager {
	public BeanRecRecp add(int goods_id, String recipe_detail) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecRecp recipe = new BeanRecRecp();
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT goods_id FROM fresh_goods WHERE goods_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, goods_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此商品编号");
			pst.close();
			rs.close();
			sql = "INSERT INTO fresh_recrecp(goods_id, recipe_detail) VALUES(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, goods_id);
			pst.setString(2, recipe_detail);
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
		return recipe;
	}	
	
	public BeanRecRecp find(int recipe_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecRecp recipe = new BeanRecRecp();
		Connection conn = null;
		int id = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT recipe_id FROM fresh_recrecp WHERE recipe_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("无此菜谱编号");
			pst.close();
			rs.close();
			sql = "SELECT goods_id, recipe_detail FROM fresh_recrecp WHERE recipe_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				recipe.setRecipe_id(recipe_id);
				recipe.setGoods_id(rs.getInt(1));
				recipe.setRecipe_detail(rs.getString(2));
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
		return recipe;
	}	
	
	public BeanRecRecp modify(int recipe_id, int goods_id, String detail) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecRecp recipe = new BeanRecRecp();
		Connection conn = null;
		int id1 = 0;
		int id2 = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT recipe_id FROM fresh_recrecp WHERE recipe_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id1 = rs.getInt(1);
			if(id1 == 0)
				throw new BaseException("无此菜谱编号");
			pst.close();
			rs.close();
			sql = "SELECT goods_id FROM fresh_recrecp WHERE recipe_id = ?";
			pst.setInt(1, recipe_id);
			rs = pst.executeQuery();
			if(rs.next())
				id2 = rs.getInt(1);
			if(id2 != 0)
				throw new BaseException("已有此商品的推荐");
			
			sql = "SELECT goods_id, recipe_detail FROM fresh_recrecp WHERE recipe_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				recipe.setRecipe_id(recipe_id);
				recipe.setGoods_id(rs.getInt(1));
				recipe.setRecipe_detail(rs.getString(2));
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
		return recipe;
	}		
	
	public void del_recRecipe(int recipe_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecRecp recipe = new BeanRecRecp();
		Connection conn = null;
		int id1 = 0;
		int id2 = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT recipe_id FROM fresh_recrecp WHERE recipe_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id1 = rs.getInt(1);
			if(id1 == 0)
				throw new BaseException("无此菜谱编号");
			pst.close();
			rs.close();
			sql = "SELECT COUNT(goods_id) FROM fresh_recrecp WHERE recipe_id = ?";
			pst.setInt(1, recipe_id);
			rs = pst.executeQuery();
			if(rs.next())
				id2 = rs.getInt(1);
			if(id2 > 0)
				throw new BaseException("此菜谱编号下有商品，无法删除");
			sql = "DELETE FROM fresh_recrecp WHERE recipe_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
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
	
	public void del_recRecipe_goods(int recipe_id, int goods_id) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecRecp recipe = new BeanRecRecp();
		Connection conn = null;
		int id1 = 0;
		int id2 = 0;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT recipe_id FROM fresh_recrecp WHERE recipe_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id1 = rs.getInt(1);
			if(id1 == 0)
				throw new BaseException("无此菜谱编号");
			pst.close();
			rs.close();
			sql = "SELECT goods_id FROM fresh_recrecp WHERE goods_id = ?";
			pst.setInt(1, recipe_id);
			rs = pst.executeQuery();
			if(rs.next())
				id2 = rs.getInt(1);
			if(id2 == 0)
				throw new BaseException("无此商品编号");
			pst.close();
			rs.close();
			sql = "DELETE FROM fresh_recrecp WHERE recipe_id = ? AND goods_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, recipe_id);
			pst.setInt(2, goods_id);
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
