package cn.mldn.dibmp.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StorageApplyDetails implements Serializable {
	 private Long sadid;
	 private Long gid;
	 private String name;
	 private Integer num;
	 private Double pirce;
	 private Double weight;
	public Long getSadid() {
		return sadid;
	}
	public void setSadid(Long sadid) {
		this.sadid = sadid;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPirce() {
		return pirce;
	}
	public void setPirce(Double pirce) {
		this.pirce = pirce;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "StorageApplyDetails [sadid=" + sadid + ", gid=" + gid + ", name=" + name + ", num=" + num + ", pirce="
				+ pirce + ", weight=" + weight + "]";
	}
	 
	 
}