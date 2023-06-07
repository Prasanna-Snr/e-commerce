package com.spring.myProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;




@Entity
@Table(name = "product_tbl")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	private int weight;
	private String description;
	@Transient
	private MultipartFile image;
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;
	private String imageName;
	
	
	

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getWeight() {
		return weight;
	}

	public String getDescription() {
		return description;
	}

	public Category getCategory() {
		return category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
