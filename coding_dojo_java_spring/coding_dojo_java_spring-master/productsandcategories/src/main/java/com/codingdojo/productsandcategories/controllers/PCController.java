package com.codingdojo.productsandcategories.controllers;
// Web Stuff
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// Needed user-defined classes
import com.codingdojo.productsandcategories.models.*;
import com.codingdojo.productsandcategories.services.*;
//Other Java classes needed
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PCController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public PCController(ProductService productService,
			CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products/new")
	public String newProductForm(@ModelAttribute("product") Product p) {
		return "newProductForm.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product p,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newProductForm.jsp";
		} else {
			Product newProduct = productService.createProduct(p);
			return "redirect:/products/" + newProduct.getId(); 
		}
	}
	
	@RequestMapping("/categories/new")
	public String newCategoryForm(@ModelAttribute("category") Category c) {
		return "newCategoryForm.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String newCategoryForm(@Valid @ModelAttribute("category") Category c,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newCategoryForm.jsp";
		} else {
			Category newCategory = categoryService.createCategory(c);
			return "redirect:/categories/" + newCategory.getId();
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id,
			@ModelAttribute("category") Category c,
			Model model) {
		Product p = productService.findProduct(id);
		Map<String, String> additionalCategories = new HashMap<String, String>();
		additionalCategories = categoryService.getAvailableCategories(p);
		model.addAttribute("additionalCategories", additionalCategories);
		model.addAttribute("product", p);
		return "product.jsp";
	}
	
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	public String addCategory(@PathVariable("id") Long id,
			@Valid @ModelAttribute("category") Category c,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("this is an error");
			return "redirect:/products/" + id;
		} else {
			Product p = productService.findProduct(id);
			productService.addCategory(p,
					categoryService.findCategory(
							Long.parseLong(c.getName())
							)
					);
			return "redirect:/products/" + id;
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id,
			@ModelAttribute("product") Product p,
			Model model) {
		Category c = categoryService.findCategory(id);
		Map<String, String> additionalProducts = new HashMap<String, String>();
		additionalProducts = productService.getAvailableProducts(c);
		model.addAttribute("additionalProducts", additionalProducts);
		model.addAttribute("category", c);
		return "category.jsp";
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
	public String addProduct(@PathVariable("id") Long id,
			@Valid @ModelAttribute("product") Product p,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:/categories/" + id;
		} else {
			Category c = categoryService.findCategory(id);
			categoryService.addProduct(c,
					productService.findProduct(
							Long.parseLong(p.getName()
									)
							)
					);
			return "redirect:/categories/" + id;
		}
	}
}
