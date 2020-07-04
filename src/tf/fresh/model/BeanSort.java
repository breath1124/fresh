package tf.fresh.model;


//生鲜类别
public class BeanSort {
	private int category_id;		//类别编号
	private String category_name;	//类别名称
	private String category_detail; //类别描述
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_detail() {
		return category_detail;
	}
	public void setCategory_detail(String category_detail) {
		this.category_detail = category_detail;
	}
	
	
}
