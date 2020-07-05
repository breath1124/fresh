package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanRecipe;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class RecipeManager {
	//图片还没加
	public BeanRecipe add(String name, String materials, String step) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecipe recipe = new BeanRecipe();
		String str = null;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT recipe_name FROM fresh_recipe WHERE recipe_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				str = rs.getString(1);
			if(str != null)
				throw new BaseException("已有此菜谱");
			pst.close();
			rs.close();
			
			//图片还没加，后期有空加
			sql = "INSERT INTO fresh_recipe(recipe_name,recipe_materials,recipe_step) VALUES(?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, materials);
			pst.setString(3, step);
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
	
	public BeanRecipe find(String recipe_name) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecipe recipe = new BeanRecipe();
		int id = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			//图片后面再加
			String sql = "SELECT recipe_id FROM fresh_recipe WHERE recipe_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, recipe_name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("没有此菜谱");
			pst.close();
			rs.close();
			
			//图片还没加，后期有空加
			sql = "SELECT recipe_id, recipe_materials, recipe_step FROM fresh_recipe WHERE recipe_name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, recipe_name);
			rs = pst.executeQuery();
			while(rs.next())
			{
				recipe.setRecipe_id(rs.getInt(1));
				recipe.setRecipe_name(recipe_name);
				recipe.setRecipe_materials(rs.getString(2));
				recipe.setRecipe_step(rs.getString(3));
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
	
	public BeanRecipe modify(String oldName, String newName, String materials, String step) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecipe recipe = new BeanRecipe();
		int id = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			//图片后面再加
			String sql = "SELECT recipe_id FROM fresh_recipe WHERE recipe_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, oldName);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("没有此菜谱");
			pst.close();
			rs.close();
			
			//图片还没加，后期有空加
			sql = "UPDATE fresh_recipe SET recipe_name = ?, recipe_materials = ?, recipe_step = ? WHERE recipe_name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, newName);
			pst.setString(2, materials);
			pst.setString(3, step);
			pst.setString(4, oldName);
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
	
	public void del(String recipe_name) throws BaseException {
		// TODO Auto-generated method stub
		BeanRecipe recipe = new BeanRecipe();
		int id = 0;
		int id2 = 0;
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			//图片后面再加
			String sql = "SELECT recipe_id FROM fresh_recipe WHERE recipe_name = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, recipe_name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			if(id == 0)
				throw new BaseException("没有此菜谱");
			pst.close();
			rs.close();
			sql = "SELECT recipe FROM fresh_recrecp WHERE recipe_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next())
				id2 = rs.getInt(1);
			if(id2 > 0)
				throw new BaseException("菜谱推荐中有此菜谱，请先删除相应的菜谱推荐");   //这里是无法删除还是连同推荐一起删除还没想好，后期再改
			pst.close();
			rs.close();
			//图片还没加，后期有空加
			sql = "DELETE FROM fresh_recipe WHERE recipe_name = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, recipe_name);
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
