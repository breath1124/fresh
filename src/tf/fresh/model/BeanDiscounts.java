package tf.fresh.model;

import java.sql.Date;

//�Ż�ȯ
public class BeanDiscounts {
	private int discnt_id;				//�Ż�ȯ���
	private String discnt_detail;		//����
	private double discnt_suitMoney;	//���ý��
	private double discnt_minuMoney;	//������
	private Date discnt_begin;			//��ʼ����
	private Date discnt_end;			//��������
	public int getDiscnt_id() {
		return discnt_id;
	}
	public void setDiscnt_id(int discnt_id) {
		this.discnt_id = discnt_id;
	}
	public String getDiscnt_detail() {
		return discnt_detail;
	}
	public void setDiscnt_detail(String discnt_detail) {
		this.discnt_detail = discnt_detail;
	}
	public double getDiscnt_suitMoney() {
		return discnt_suitMoney;
	}
	public void setDiscnt_suitMoney(double discnt_suitMoney) {
		this.discnt_suitMoney = discnt_suitMoney;
	}
	public double getDiscnt_minuMoney() {
		return discnt_minuMoney;
	}
	public void setDiscnt_minuMoney(double discnt_minuMoney) {
		this.discnt_minuMoney = discnt_minuMoney;
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
