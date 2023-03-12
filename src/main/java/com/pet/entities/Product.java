package com.pet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

//"id": "1",
//"name": "Blue Macaw",
//"price": 25000,
//"description": "This is a very attractive bird.",
//"category": "Bird"

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@NotBlank(message="Invalid Product Name")
	@Column(name="product_name",nullable=false)
	private String productName;
	
	@Column(name="product_cost",nullable=false)
	private float productCost;
	
//	@Column(name="breed")
//	private String productBreed;
	
	@Column(name="category",nullable=false)
	private String productCategory;
	
	@Column(name="description")
	private String productDescription;

	public Product() {
		super();
	}

	public Product(int productId, @NotBlank(message = "Invalid Product Name") String productName, float productCost,
			String productBreed, String productCategory, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
//		this.productBreed = productBreed;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductCost() {
		return productCost;
	}

	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}

//	public String getProductBreed() {
//		return productBreed;
//	}
//
//	public void setProductBreed(String productBreed) {
//		this.productBreed = productBreed;
//	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productStock=" +", productCategory="
				+ productCategory + ", productDescription=" + productDescription + "]";
	}
}
