package tf.fresh.model;

import java.io.File;


//²ËÆ×ĞÅÏ¢
public class BeanRecipe {
	private int recipe_id;				//²ËÆ×±àºÅ
	private String recipe_name;			//²ËÆ×Ãû³Æ
	private String recipe_materials;	//²ËÆ×ÓÃÁÏ
	private String recipe_step;			//²½Öè
	private File recipe_picture;		//Í¼Æ¬
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_materials() {
		return recipe_materials;
	}
	public void setRecipe_materials(String recipe_materials) {
		this.recipe_materials = recipe_materials;
	}
	public String getRecipe_step() {
		return recipe_step;
	}
	public void setRecipe_step(String recipe_step) {
		this.recipe_step = recipe_step;
	}
	public File getRecipe_picture() {
		return recipe_picture;
	}
	public void setRecipe_picture(File recipe_picture) {
		this.recipe_picture = recipe_picture;
	}
	
	
}
