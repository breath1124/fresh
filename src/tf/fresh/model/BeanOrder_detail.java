package tf.fresh.model;


//订单详情
public class BeanOrder_detail {
	private int goods_id;			//商品编号
	private int order_id;			//订单编号
	private int full_id;			//满折编号
	private int goods_cnt;			//数量
	private double goods_price;		//价格
	private double full_discnt;		//折扣
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getFull_id() {
		return full_id;
	}
	public void setFull_id(int full_id) {
		this.full_id = full_id;
	}
	public int getGoods_cnt() {
		return goods_cnt;
	}
	public void setGoods_cnt(int goods_cnt) {
		this.goods_cnt = goods_cnt;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public double getFull_discnt() {
		return full_discnt;
	}
	public void setFull_discnt(double full_discnt) {
		this.full_discnt = full_discnt;
	}
	
	
}
