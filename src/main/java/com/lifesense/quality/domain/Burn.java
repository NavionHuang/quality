package com.lifesense.quality.domain;

import java.util.Date;

/**
 * 邦板烧录
 * 
 * @author 2018040005
 *
 */
public class Burn {
	private Long id;
	private String sn;
	private String name;
	private String version;
	private String mac;
	private String po;
	private Date createTime;
	private String remark;
	private Long productId;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Burn [id=" + id + ", sn=" + sn + ", name=" + name + ", version=" + version + ", mac=" + mac + ", po="
				+ po + ", createTime=" + createTime + ", remark=" + remark + ", productId=" + productId + "]";
	}
	
}
