package cn.edu.zzuli.store.vo;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年6月1日下午3:17:32 TODO
 */
public class OutStore {

	private int id;
	private int did;
	private String wareName;
	private String outTime;
	private double weight;
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public double getWeight() {
		return weight;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
