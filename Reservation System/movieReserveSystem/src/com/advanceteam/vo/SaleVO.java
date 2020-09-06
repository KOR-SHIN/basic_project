package com.advanceteam.vo;
/**
 * 
 * @author shink
 * @since 2020-08-30
 */
public class SaleVO {

	private String sale_id; // PK
	private int sale_price;

	public String getSale_id() {
		return sale_id;
	}

	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

}
