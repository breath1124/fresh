package tf.fresh.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tf.fresh.model.BeanAdmin;
import tf.fresh.model.BeanUsr;
import tf.fresh.util.BaseException;
import tf.fresh.util.BusinessException;
import tf.fresh.util.DBUtil;
import tf.fresh.util.DbException;

public class UsrManager {
	public BeanUsr reg(String usr_id, String pwd,String pwd2, String usr_name, String usr_sex, String usr_tel, String usr_email, String usr_city) throws BaseException {
		// TODO Auto-generated method stub
		if("".equals(usr_id))	throw new BaseException("用户id不能为空");
		if(!pwd.equals(pwd2))
			throw new BaseException("两次输入密码不一致");
		BeanUsr usr = new BeanUsr();
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select usr_id from fresh_usr where usr_id = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, usr_id);
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				if(rs.getString(1).equals(usr_id))
					throw new BaseException("用户id已存在");
			}
			rs.close();
			pst.close();
			sql = "INSERT INTO fresh_usr VALUES (?,?,?,?,?,?,?,current_timestamp,null,null)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, usr_id);
			pst.setString(2, usr_name);
			pst.setString(3, usr_sex);
			pst.setString(4, pwd);
			pst.setString(5, usr_tel);
			pst.setString(6, usr_email);
			pst.setString(7, usr_city);
			pst.execute();
			usr.setUsr_id(usr_id);
			usr.setUsr_name(usr_name);
			usr.setUsr_sex(usr_sex);
			usr.setUsr_pwd(pwd);
			usr.setUsr_tel(usr_tel);
			usr.setUsr_email(usr_email);
			usr.setUsr_city(usr_city);
			usr.setUsr_isVIP(null);
			usr.setUsr_vipDDL(null);
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
		return usr;
	}
	
	public BeanUsr login(String usr_id, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		BeanUsr usr = new BeanUsr();
		String pass = null;
		usr.setUsr_id(usr_id);
		usr.setUsr_pwd(pwd);
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT usr_pwd FROM fresh_usr WHERE usr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, usr_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				pass = rs.getString(1);
			if(!pass.equals(usr.getUsr_pwd()))
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
		return usr;
	}	
	
	public void changePwd(BeanUsr usr, String oldPwd, String newPwd,
			String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT usr_pwd FROM fresh_usr WHERE usr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,usr.getUsr_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next())
				if(!oldPwd.equals(rs.getString(1)))	
					throw new BusinessException("用户名或密码错误");
			rs.close();
			pst.close();
			if(!newPwd.equals(newPwd2))
				throw new BusinessException("两次输入密码不一致");
			sql="UPDATE fresh_usr SET usr_pwd = ? WHERE usr_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,newPwd);
			pst.setString(2, usr.getUsr_id());
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
	
	public BeanUsr del(String usr_id, String pwd, String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		BeanUsr usr = new BeanUsr();
		String pass = null;
		usr.setUsr_id(usr_id);
		usr.setUsr_pwd(pwd);
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			String sql = "SELECT usr_pwd FROM fresh_usr WHERE usr_id = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, usr_id);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
				pass = rs.getString(1);
			if(!pass.equals(usr.getUsr_pwd()))
				throw new BaseException("用户名或密码错误");
			if(!pwd.equals(pwd2))
				throw new BusinessException("两次输入密码不一致");
			sql = "DELETE FROM fresh_usr WHERE usr_id = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, usr_id);
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
		return usr;
	}	
}
