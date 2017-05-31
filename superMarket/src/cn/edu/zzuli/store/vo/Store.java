package cn.edu.zzuli.store.vo;

import java.util.Date;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:34:51 TODO
 */
public class Store {

	private int id;

	private String khm;

	private String orderNum;

	private Date pushDate;

	private String productName;

	private double price;

	private int count;

	private int status;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKhm() {
		return khm;
	}

	public void setKhm(String khm) {
		this.khm = khm;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Date getPushDate() {
		return pushDate;
	}

	public void setPushDate(Date pushDate) {
		this.pushDate = pushDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
