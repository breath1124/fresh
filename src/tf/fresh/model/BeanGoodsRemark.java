package tf.fresh.model;

import java.io.File;
import java.sql.Date;

//商品评价
public class BeanGoodsRemark {
	private int remark_id;			//评价编号
	private int goods_id;			//商品编号(应该用不到了)
	private String usr_id;			//用户编号
	private String remark_detail;	//评价内容
	private Date remark_date;		//评价日期
	private String remark_star;		//评价星级
	private File remark_picture;	//评价图片
	public int getRemark_id() {
		return remark_id;
	}
	public void setRemark_id(int remark_id) {
		this.remark_id = remark_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public String getRemark_detail() {
		return remark_detail;
	}
	public void setRemark_detail(String remark_detail) {
		this.remark_detail = remark_detail;
	}
	public Date getRemark_date() {
		return remark_date;
	}
	public void setRemark_date(Date remark_date) {
		this.remark_date = remark_date;
	}
	public String getRemark_star() {
		return remark_star;
	}
	public void setRemark_star(String remark_star) {
		this.remark_star = remark_star;
	}
	public File getRemark_picture() {
		return remark_picture;
	}
	public void setRemark_picture(File remark_picture) {
		this.remark_picture = remark_picture;
	}
	
	
}
