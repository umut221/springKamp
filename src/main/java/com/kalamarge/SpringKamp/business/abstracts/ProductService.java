package com.kalamarge.SpringKamp.business.abstracts;

import java.util.List;

import com.kalamarge.SpringKamp.core.utilities.results.DataResult;
import com.kalamarge.SpringKamp.core.utilities.results.Result;
import com.kalamarge.SpringKamp.entities.concretes.Product;
import com.kalamarge.SpringKamp.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	DataResult<List<Product>> getAllSorted();
	Result add(Product product);
	Result deleteById(int id);
	DataResult<Product> getByProductName(String productName);
	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	DataResult<List<Product>> getByProductNameContains(String productName);
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}