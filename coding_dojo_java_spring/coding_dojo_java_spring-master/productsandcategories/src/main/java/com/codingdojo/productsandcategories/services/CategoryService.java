package com.codingdojo.productsandcategories.services;

import com.codingdojo.productsandcategories.repositories.CategoryRepository;
import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;

//Other Java classes needed
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	public final CategoryRepository catRepo;
	
	public CategoryService(CategoryRepository catRepo) {
		this.catRepo = catRepo;
	}
	
	public List<Category> findAll(){
		return catRepo.findAll();
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = catRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public Category createCategory(Category c) {
		return catRepo.save(c);
	}
	
	public void addProduct(Category c, Product p) {
		List<Product> pList = c.getProducts();
		pList.add(p);
		c.setProducts(pList);
		catRepo.save(c);
	}
	
	public Map<String,String> getAvailableCategories(Product p){
		
		Map<String, String> cats = new HashMap<String,String>();
		List<Category> availableCats = new ArrayList<Category>();
		List<Category> usedCats = p.getCategories();
		List<Long> usedCatsIds = new ArrayList<Long>();
		
		if (usedCats.size() > 0) {
			for (var i = 0; i < usedCats.size(); i++){
				Category temp = usedCats.get(i);
				Long tempId = temp.getId();
				usedCatsIds.add(tempId);
			}
			availableCats = catRepo.findByIdNotIn(usedCatsIds);
		} else {
			availableCats = findAll();
		}
		
		for (var i = 0; i < availableCats.size(); i++) {
			cats.put(Long.toString(availableCats.get(i).getId()), availableCats.get(i).getName());
		}
		
		System.out.println(availableCats);
		return cats;
	}
}
