package com.codingdojo.productsandcategories.services;

import com.codingdojo.productsandcategories.repositories.ProductRepository;
import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	public void addCategory(Product p, Category c) {
		List<Category> cList = p.getCategories();
		cList.add(c);
		p.setCategories(cList);
		productRepo.save(p);
	}
	
	public Map<String,String> getAvailableProducts(Category c){
		Map<String, String> products = new HashMap<String,String>();
		List<Product> availableProducts = new ArrayList<Product>();
		List<Product> usedProducts = c.getProducts();
		List<Long> usedProductsIds = new ArrayList<Long>();
		if (usedProducts.size() > 0) {
			for (var i = 0; i < usedProductsIds.size(); i++){
				Product temp = usedProducts.get(i);
				Long tempId = temp.getId();
				usedProductsIds.add(tempId);
			}
			availableProducts = productRepo.findByIdNotIn(usedProductsIds);
		} else {
			availableProducts = findAll();
		}

		for (var i = 0; i < availableProducts.size(); i++) {
			products.put(Long.toString(availableProducts.get(i).getId()), availableProducts.get(i).getName());
		}
		return products;
	} 
}
