package com.kalamarge.SpringKamp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kalamarge.SpringKamp.business.abstracts.ProductService;
import com.kalamarge.SpringKamp.core.utilities.results.DataResult;
import com.kalamarge.SpringKamp.core.utilities.results.Result;
import com.kalamarge.SpringKamp.core.utilities.results.SuccessDataResult;
import com.kalamarge.SpringKamp.core.utilities.results.SuccessResult;
import com.kalamarge.SpringKamp.dataAccess.abstracts.ProductDao;
import com.kalamarge.SpringKamp.entities.concretes.Product;
import com.kalamarge.SpringKamp.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>>  getAll() {
		return new SuccessDataResult<List<Product>>(
				this.productDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}
	
	@Override
	public Result deleteById(int id) {
		this.productDao.deleteById(id);
		return new SuccessResult("Ürün silindi");
		}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName));
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId));
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId));
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories));
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName));
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName));
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId));
	}
	
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(PageRequest.of(pageNo-1, pageSize)).getContent());
	}
	
	@Override
	public DataResult<List<Product>> getAllSorted() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(Sort.by(Sort.Direction.ASC,"productName")));
	}
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails());
	}
}
