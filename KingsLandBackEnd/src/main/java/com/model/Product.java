 package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
 @Entity
 public class Product implements Serializable {
 	
 @Id
 @GeneratedValue
 private int pid;
 private String productName;
 private String description;
 private double price;
 private int stock;

 @ManyToOne(fetch= FetchType.EAGER)
 @JoinColumn(name="cid")
 private Category category;

 @ManyToOne(fetch= FetchType.EAGER)
 @JoinColumn(name="sid")
 private Supplier supplier;

 @Transient
 MultipartFile pimage;

 private String imgName;

 public int getPid() {
 	return pid;
 }

 public void setPid(int pid) {
 	this.pid = pid;
 }

 

 public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getDescription() {
 	return description;
 }

 public void setDescription(String description) {
 	this.description = description;
 }

 public double getPrice() {
 	return price;
 }

 public void setPrice(double price) {
 	this.price = price;
 }

 public int getStock() {
 	return stock;
 }

 public void setStock(int stock) {
 	this.stock = stock;
 }

 public Category getCategory() {
 	return category;
 }

 public void setCategory(Category category) {
 	this.category = category;
 }

 public Supplier getSupplier() {
 	return supplier;
 }

 public void setSupplier(Supplier supplier) {
 	this.supplier = supplier;
 }

 public MultipartFile getPimage() {
 	return pimage;
 }

 public void setPimage(MultipartFile pimage) {
 	this.pimage = pimage;
 }

 public String getImgName() {
 	return imgName;
 }

 public void setImgName(String imgName) {
 	this.imgName = imgName;
 }

 }