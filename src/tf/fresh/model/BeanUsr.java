package tf.fresh.model;

import java.sql.Date;

//用户信息
public class BeanUsr {
	private String usr_id;			//用户编号
	private String usr_name;		//用户姓名
	private String usr_sex;			//用户性别
	private String usr_pwd;			//登录密码
	private String usr_tel;			//手机号码
	private String usr_email;		//电子邮箱
	private String usr_city;		//所在城市
	private Date usr_registerTime;	//注册时间
	private String usr_isVIP;		//是否为VIP
	private Date usr_vipDDL;		//VIP到期时间

	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_sex() {
		return usr_sex;
	}
	public void setUsr_sex(String usr_sex) {
		this.usr_sex = usr_sex;
	}
	public String getUsr_pwd() {
		return usr_pwd;
	}
	public void setUsr_pwd(String usr_pwd) {
		this.usr_pwd = usr_pwd;
	}
	public String getUsr_tel() {
		return usr_tel;
	}
	public void setUsr_tel(String usr_tel) {
		this.usr_tel = usr_tel;
	}
	public String getUsr_email() {
		return usr_email;
	}
	public void setUsr_email(String usr_email) {
		this.usr_email = usr_email;
	}
	public String getUsr_city() {
		return usr_city;
	}
	public void setUsr_city(String usr_city) {
		this.usr_city = usr_city;
	}
	public Date getUsr_registerTime() {
		return usr_registerTime;
	}
	public void setUsr_registerTime(Date usr_registerTime) {
		this.usr_registerTime = usr_registerTime;
	}
	public String getUsr_isVIP() {
		return usr_isVIP;
	}
	public void setUsr_isVIP(String usr_isVIP) {
		this.usr_isVIP = usr_isVIP;
	}
	public Date getUsr_vipDDL() {
		return usr_vipDDL;
	}
	public void setUsr_vipDDL(Date usr_vipDDL) {
		this.usr_vipDDL = usr_vipDDL;
	}
	
	
}
