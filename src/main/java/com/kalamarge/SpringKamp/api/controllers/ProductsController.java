package com.kalamarge.SpringKamp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kalamarge.SpringKamp.business.abstracts.ProductService;
import com.kalamarge.SpringKamp.core.utilities.results.DataResult;
import com.kalamarge.SpringKamp.core.utilities.results.Result;
import com.kalamarge.SpringKamp.entities.concretes.Product;
import com.kalamarge.SpringKamp.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getAllPageable")
	public DataResult<List<Product>> getAllPageable(@RequestParam int pageNo, @RequestParam int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {	
		return this.productService.add(product);
	}
	
	@PostMapping("/delete")
	public Result delete(int id) {
		return this.productService.deleteById(id);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
			@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
		
	}
	@GetMapping("/getAllSorted")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
}
