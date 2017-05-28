package cn.edu.zzuli.record.vo;

public class Seller {

	private String sid;
	private String name;
	private String khm;
	private String address;
	private String connecter;
	private String contel;
	private String fax;
	private String email;
	private String account;
	private String wsite;
	private String description;
	private String postCode;
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getKhm() {
		return khm;
	}
	public void setKhm(String khm) {
		this.khm = khm;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getConnecter() {
		return connecter;
	}
	public void setConnecter(String connecter) {
		this.connecter = connecter;
	}
	public String getContel() {
		return contel;
	}
	public void setContel(String contel) {
		this.contel = contel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getWsite() {
		return wsite;
	}
	public void setWsite(String wsite) {
		this.wsite = wsite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", name=" + name + ", address=" + address
				+ " contel=" + contel + ", fax="
				+ fax + ", email=" + email + ", account=" + account
				+ ", wsite=" + wsite + ", description=" + description + "]";
	}
	
	
	
}
