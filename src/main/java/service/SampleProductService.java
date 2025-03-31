package com.mymart.mymart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymart.mymart.entity.SampleProductEntity;
import com.mymart.mymart.repository.SampleProductRepository;

import jakarta.transaction.Transactional;

@Service
public class SampleProductService {

	
	public SampleProductRepository repoObject;
	
	@Autowired
	public SampleProductService(SampleProductRepository obj) {
		this.repoObject=obj;
	}
	
	public List<SampleProductEntity> getAllProducts(){
		return repoObject.findAll();
	} 
	
	public SampleProductEntity findProductById(int id) {
		return repoObject.findById(id);
		
	}
	
	@Transactional
	public void saveProduct(String productName, String productCategory,int price,int discount) {
		repoObject.insert(productName, productCategory, price, discount);
	}
}
