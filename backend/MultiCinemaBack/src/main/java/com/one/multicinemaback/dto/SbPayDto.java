package com.one.multicinemaback.dto;

public class SbPayDto {
	
	private String tid;
	private String id;
	private String product;
	private int count;
	private int payprice;
	
	public SbPayDto() {
	}

	public SbPayDto(String tid, String id, String product, int count, int payprice) {
		super();
		this.tid = tid;
		this.id = id;
		this.product = product;
		this.count = count;
		this.payprice = payprice;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPayprice() {
		return payprice;
	}

	public void setPayprice(int payprice) {
		this.payprice = payprice;
	}
	

}
