package com.jsp.hibernate.Shopping_Cart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int productId;
	private String prodouctName;
	private String productBrand;
	private int productPrice;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProdouctName() {
		return prodouctName;
	}
	public void setProdouctName(String prodouctName) {
		this.prodouctName = prodouctName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodouctName=" + prodouctName + ", productBrand=" + productBrand
				+ ", productPrice=" + productPrice + "]";
	}
	
	

}