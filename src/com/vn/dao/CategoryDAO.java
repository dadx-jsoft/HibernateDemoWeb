package com.vn.dao;

import java.util.List;

import com.vn.entities.Category;

public interface CategoryDAO {
	public abstract List<Category> getAllCategory();
	public abstract boolean deleteCategory(int idCategory);
	public abstract boolean updateCategory(Category category);
	public abstract int insertCategory(Category category);
	
	public abstract Category findCategoryById(int find_id);
}
