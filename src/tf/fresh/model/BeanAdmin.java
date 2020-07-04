package tf.fresh.model;

//管理员信息
public class BeanAdmin {
	private String staff_id;		//员工编号
	private String staff_name;	//员工姓名
	private String admin_pwd;	//登录密码

	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	
	
}
