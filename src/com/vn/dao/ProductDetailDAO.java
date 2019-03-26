package com.vn.dao;

import java.util.List;

import com.vn.entities.ProductDetail;

public interface ProductDetailDAO {
	public abstract List<ProductDetail> getAllProductDetail();
	public abstract boolean deleteProductDetail(int idProductDetail);
	public abstract boolean updateProductDetail(ProductDetail productDetail);
	public abstract int insertProductDetail(ProductDetail productDetail);
}
