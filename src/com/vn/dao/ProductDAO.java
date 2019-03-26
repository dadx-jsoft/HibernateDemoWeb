package com.vn.dao;

import java.util.List;

import com.vn.entities.Product;

public interface ProductDAO {
	public abstract List<Product> getAllProduct();
	public abstract boolean deleteProduct(int idProduct);
	public abstract boolean updateProduct(Product product);
	public abstract int insertProduct(Product product);
	
	public abstract Product findRecordById(int find_product_id);
}
