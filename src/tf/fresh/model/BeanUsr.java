package tf.fresh.model;

import java.sql.Date;

//�û���Ϣ
public class BeanUsr {
	private String usr_id;			//�û����
	private String usr_name;		//�û�����
	private String usr_sex;			//�û��Ա�
	private String usr_pwd;			//��¼����
	private String usr_tel;			//�ֻ�����
	private String usr_email;		//��������
	private String usr_city;		//���ڳ���
	private Date usr_registerTime;	//ע��ʱ��
	private String usr_isVIP;		//�Ƿ�ΪVIP
	private Date usr_vipDDL;		//VIP����ʱ��

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
