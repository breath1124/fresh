package tf.fresh.model;

//商品采购
public class BeanGoods_buy {
	private int buy_id;			//采购单编号
	private String staff_id;	//员工编号
	private int goods_id;		//商品编号
	private int buy_cnt;		//数量
	private String buy_state;	//状态
	public int getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(int buy_id) {
		this.buy_id = buy_id;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getBuy_cnt() {
		return buy_cnt;
	}
	public void setBuy_cnt(int buy_cnt) {
		this.buy_cnt = buy_cnt;
	}
	public String getBuy_state() {
		return buy_state;
	}
	public void setBuy_state(String buy_state) {
		this.buy_state = buy_state;
	}
	
	
}
