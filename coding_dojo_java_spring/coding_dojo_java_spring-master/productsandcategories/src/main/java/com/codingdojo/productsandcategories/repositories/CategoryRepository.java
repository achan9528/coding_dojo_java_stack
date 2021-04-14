package com.codingdojo.productsandcategories.repositories;

import java.util.List;
import com.codingdojo.productsandcategories.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	
	List<Category> findByIdNotIn(List<Long> productCats);
}
