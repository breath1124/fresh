package tf.fresh.model;

import java.sql.Date;

//��Ʒ����
public class BeanOrder {
	private int order_id;			//�������
	private int discnt_id;			//�Ż�ȯ���
	private String usr_id;				//�û����
	private double init_money;		//ԭʼ���
	private double final_money;		//������
	private Date deliver_time;		//�ʹ�ʱ��
	private int addr_id;			//���͵�ַ���
	private String order_state;		//����״̬
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getDiscnt_id() {
		return discnt_id;
	}
	public void setDiscnt_id(int discnt_id) {
		this.discnt_id = discnt_id;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}
	public double getInit_money() {
		return init_money;
	}
	public void setInit_money(double init_money) {
		this.init_money = init_money;
	}
	public double getFinal_money() {
		return final_money;
	}
	public void setFinal_money(double final_money) {
		this.final_money = final_money;
	}
	public Date getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(Date deliver_time) {
		this.deliver_time = deliver_time;
	}
	public int getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	
	
}
