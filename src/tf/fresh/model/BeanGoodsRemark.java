package tf.fresh.model;

import java.io.File;
import java.sql.Date;

//��Ʒ����
public class BeanGoodsRemark {
	private int remark_id;			//���۱��
	private int goods_id;			//��Ʒ���(Ӧ���ò�����)
	private String usr_id;			//�û����
	private String remark_detail;	//��������
	private Date remark_date;		//��������
	private String remark_star;		//�����Ǽ�
	private File remark_picture;	//����ͼƬ
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
