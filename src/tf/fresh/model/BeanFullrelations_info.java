package tf.fresh.model;

import java.sql.Date;

//满折商品关联
public class BeanFullrelations_info {
	private int full_id;		//满折编号
	private int goods_id;		//商品编号
	private Date discnt_begin;	//起始时间
	private Date discnt_end;	//结束时间
	public int getFull_id() {
		return full_id;
	}
	public void setFull_id(int full_id) {
		this.full_id = full_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
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
