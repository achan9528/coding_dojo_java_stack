package com.codingdojo.productsandcategories.repositories;

import java.util.List;
import com.codingdojo.productsandcategories.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	List<Product> findByIdNotIn(List<Long> productIds);
	
}
