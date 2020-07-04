package tf.fresh.model;

import java.sql.Date;

//满折信息
public class BeanFulldiscounts_info {
	private int full_id;			//满折编号
	private String full_detail;		//内容
	private int full_suitCnt;		//适用金额
	private double disCnt;			//减免金额
	private Date full_begin;		//起始时间
	private Date full_end;			//结束时间
	public int getFull_id() {
		return full_id;
	}
	public void setFull_id(int full_id) {
		this.full_id = full_id;
	}
	public String getFull_detail() {
		return full_detail;
	}
	public void setFull_detail(String full_detail) {
		this.full_detail = full_detail;
	}
	public int getFull_suitCnt() {
		return full_suitCnt;
	}
	public void setFull_suitCnt(int full_suitCnt) {
		this.full_suitCnt = full_suitCnt;
	}
	public double getDiscnt() {
		return disCnt;
	}
	public void setDiscnt(double discnt) {
		this.disCnt = discnt;
	}
	public Date getFull_begin() {
		return full_begin;
	}
	public void setFull_begin(Date full_begin) {
		this.full_begin = full_begin;
	}
	public Date getFull_end() {
		return full_end;
	}
	public void setFull_end(Date full_end) {
		this.full_end = full_end;
	}
	
	
}
