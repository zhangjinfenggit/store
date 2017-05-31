package cn.edu.zzuli.dept.vo;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日下午3:36:54 TODO
 */
public class Dept {

	private int id;
	private String name;
	private String principal;// 负责人
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
