package com.mymart.mymart.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymart.mymart.dao.SampleProductDao;
import com.mymart.mymart.entity.SampleProductEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class SampleProductRepository implements SampleProductDao{

	//@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public SampleProductRepository(EntityManager em) {
		this.entityManager=em;
	}
	
	
	@Override
	public List<SampleProductEntity> findAll() {
		// TODO Auto-generated method stub
		
		TypedQuery<SampleProductEntity> query = entityManager.createQuery("from sample_product",SampleProductEntity.class);
		
		List<SampleProductEntity> products = query.getResultList();
		
		return  products;
	}

	@Override
	public SampleProductEntity findById(int id) {
		// TODO Auto-generated method stub
		SampleProductEntity product = entityManager.find(SampleProductEntity.class, id);
		return product;
	}

	@Override
	public String insert(String productName, String productCategory, int price, int discount) {
		// TODO Auto-generated method stub
		SampleProductEntity product = new SampleProductEntity(productName, productCategory, price, discount);
		entityManager.persist(product);
		return "Success";
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		SampleProductEntity product = entityManager.find(SampleProductEntity.class, id);
        if (product != null) {
            entityManager.remove(product);
            return "Product deleted successfully";
        }
        return "Product not found";
		
		//return null;
	}

}
