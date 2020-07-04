package tf.fresh.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tf.fresh.model.BeanAdmin;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class AdminManager {
	public BeanAdmin reg(String staff_id, String pwd,String pwd2, String name) throws BaseException {
		// TODO Auto-generated method stub
		if("".equals(staff_id))	throw new BaseException("员工编号不能为空");
		if(!pwd.equals(pwd2))
			throw new BaseException("两次输入密码不一致");
		BeanAdmin admin = new BeanAdmin();
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select staff_id from fresh_admin where staff_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, staff_id);
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				if(rs.getString(1).equals(staff_id))
					throw new BaseException("管理员已存在");
			}
			rs.close();
			pst.close();
			sql = "INSERT INTO fresh_admin VALUES (?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, staff_id);
			pst.setString(2, name);
			pst.setString(3, pwd);
			pst.execute();
			admin.setStaff_id(staff_id);
			admin.setStaff_name(name);
			admin.setAdmin_pwd(pwd);
			
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
		return admin;
	}
	
	public BeanAdmin login(String staff_id, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		BeanAdmin admin = new BeanAdmin();
		String pass = null;
		admin.setStaff_id(staff_id);
		admin.setAdmin_pwd(pwd);
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT admin_pwd FROM fresh_admin WHERE staff_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, staff_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				pass = rs.getString(1);
			if(!pass.equals(admin.getAdmin_pwd()))
				throw new BaseException("用户名或密码错误");
			
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
		return admin;
	}	
	
	public void changePwd(BeanAdmin admin, String oldPwd, String newPwd,
			String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT admin_pwd FROM fresh_admin WHERE sataff_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,admin.getStaff_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next())
				if(!oldPwd.equals(rs.getString(1)))	
					throw new BusinessException("用户名或密码错误");
			rs.close();
			pst.close();
			if(!newPwd.equals(newPwd2))
				throw new BusinessException("两次输入密码不一致");
			sql="UPDATE fresh_admin SET admin_pwd = ? WHERE staff_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,newPwd);
			pst.setString(2, admin.getStaff_id());
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
	
	public void del(String staff_id, String pwd, String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		BeanAdmin admin = new BeanAdmin();
		String pass = null;
		admin.setStaff_id(staff_id);
		admin.setAdmin_pwd(pwd);
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT admin_pwd FROM fresh_admin WHERE staff_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, staff_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				pass = rs.getString(1);
			if(!pass.equals(admin.getAdmin_pwd()))
				throw new BaseException("用户名或密码错误");
			if(!pwd.equals(pwd2))
				throw new BusinessException("两次输入密码不一致");
			pst.close();
			rs.close();
			sql = "DELETE FROM fresh_admin WHERE staff_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, staff_id);
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
