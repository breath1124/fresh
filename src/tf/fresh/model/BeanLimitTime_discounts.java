package tf.fresh.model;

import java.sql.Date;

//限时促销信息
public class BeanLimitTime_discounts {
	private int promotion_id;			//促销编号
	private int goods_id;				//商品编号
	private double promotion_price;		//促销价格
	private int promotion_cnt;			//促销数量
	private Date promotion_begin;		//起始时间
	private Date promotion_end;			//结束日期
	public int getPromotion_id() {
		return promotion_id;
	}
	public void setPromotion_id(int promotion_id) {
		this.promotion_id = promotion_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public double getPromotion_price() {
		return promotion_price;
	}
	public void setPromotion_price(double promotion_price) {
		this.promotion_price = promotion_price;
	}
	public int getPromotion_cnt() {
		return promotion_cnt;
	}
	public void setPromotion_cnt(int promotion_cnt) {
		this.promotion_cnt = promotion_cnt;
	}
	public Date getPromotion_begin() {
		return promotion_begin;
	}
	public void setPromotion_begin(Date promotion_begin) {
		this.promotion_begin = promotion_begin;
	}
	public Date getPromotion_end() {
		return promotion_end;
	}
	public void setPromotion_end(Date promotion_end) {
		this.promotion_end = promotion_end;
	}
	
	
}
