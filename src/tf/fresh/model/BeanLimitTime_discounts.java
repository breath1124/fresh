package tf.fresh.model;

import java.sql.Date;

//��ʱ������Ϣ
public class BeanLimitTime_discounts {
	private int promotion_id;			//�������
	private int goods_id;				//��Ʒ���
	private double promotion_price;		//�����۸�
	private int promotion_cnt;			//��������
	private Date promotion_begin;		//��ʼʱ��
	private Date promotion_end;			//��������
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
