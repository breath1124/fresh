package tf.fresh.model;

import java.sql.Date;

//商品订单
public class BeanOrder {
	private int order_id;			//订单编号
	private int discnt_id;			//优惠券编号
	private String usr_id;				//用户编号
	private double init_money;		//原始金额
	private double final_money;		//结算金额
	private Date deliver_time;		//送达时间
	private int addr_id;			//配送地址编号
	private String order_state;		//订单状态
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getDiscnt_id() {
		return discnt_id;
	}
	public void setDiscnt_id(int discnt_id) {
		this.discnt_id = discnt_id;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public double getInit_money() {
		return init_money;
	}
	public void setInit_money(double init_money) {
		this.init_money = init_money;
	}
	public double getFinal_money() {
		return final_money;
	}
	public void setFinal_money(double final_money) {
		this.final_money = final_money;
	}
	public Date getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(Date deliver_time) {
		this.deliver_time = deliver_time;
	}
	public int getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	
	
}
