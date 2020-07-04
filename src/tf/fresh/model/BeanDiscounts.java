package tf.fresh.model;

import java.sql.Date;

//优惠券
public class BeanDiscounts {
	private int discnt_id;				//优惠券编号
	private String discnt_detail;		//内容
	private double discnt_suitMoney;	//适用金额
	private double discnt_minuMoney;	//减免金额
	private Date discnt_begin;			//起始日期
	private Date discnt_end;			//结束日期
	public int getDiscnt_id() {
		return discnt_id;
	}
	public void setDiscnt_id(int discnt_id) {
		this.discnt_id = discnt_id;
	}
	public String getDiscnt_detail() {
		return discnt_detail;
	}
	public void setDiscnt_detail(String discnt_detail) {
		this.discnt_detail = discnt_detail;
	}
	public double getDiscnt_suitMoney() {
		return discnt_suitMoney;
	}
	public void setDiscnt_suitMoney(double discnt_suitMoney) {
		this.discnt_suitMoney = discnt_suitMoney;
	}
	public double getDiscnt_minuMoney() {
		return discnt_minuMoney;
	}
	public void setDiscnt_minuMoney(double discnt_minuMoney) {
		this.discnt_minuMoney = discnt_minuMoney;
	}
	public Date getDiscnt_begin() {
		return discnt_begin;
	}
	public void setDiscnt_begin(Date discnt_begin) {
		this.discnt_begin = discnt_begin;
	}
	public Date getDiscnt_end() {
		return discnt_end;
	}
	public void setDiscnt_end(Date discnt_end) {
		this.discnt_end = discnt_end;
	}
	
	
}
