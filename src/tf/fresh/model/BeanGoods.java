package tf.fresh.model;

//商品信息
public class BeanGoods {
	private int goods_id;			//商品编号
	private int category_id;		//类别名称
	private String goods_name;		//商品名称
	private double goods_price;		//价格
	private double goods_vipPrice;	//VIP价格
	private int goods_count;		//数量
	private String goods_spec;		//规格
	private String good_detail;		//详情
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public double getGoods_vipPrice() {
		return goods_vipPrice;
	}
	public void setGoods_vipPrice(double goods_vipPrice) {
		this.goods_vipPrice = goods_vipPrice;
	}
	public int getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}
	public String getGoods_spec() {
		return goods_spec;
	}
	public void setGoods_spec(String goods_spec) {
		this.goods_spec = goods_spec;
	}
	public String getGood_detail() {
		return good_detail;
	}
	public void setGood_detail(String good_detail) {
		this.good_detail = good_detail;
	}
	
	
}
