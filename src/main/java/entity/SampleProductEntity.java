package com.mymart.mymart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "sample_product")
public class SampleProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer id;

	@Column(name = "product_name")
	private String productName;

	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="price")
	private Integer maxPrice;
	
	@Column(name="discount")
	private Integer discount;
	
	
	
	public SampleProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SampleProductEntity(String productName, String productCategory, Integer maxPrice, Integer discount) {
	//	super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.maxPrice = maxPrice;
		this.discount = discount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
	
	@Override
	public String toString() {
		return "SampleProductEntity [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", maxPrice=" + maxPrice + ", discount=" + discount + "]";
	}

	


}
