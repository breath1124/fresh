package tf.fresh.model;

import java.sql.Date;

//������Ʒ����
public class BeanFullrelations_info {
	private int full_id;		//���۱��
	private int goods_id;		//��Ʒ���
	private Date discnt_begin;	//��ʼʱ��
	private Date discnt_end;	//����ʱ��
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
