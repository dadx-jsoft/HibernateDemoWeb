package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.vn.entities.Category;
import com.vn.util.HibernateUtil;

public class CategoryDAOImpl implements CategoryDAO{

	final static SessionFactory factory = HibernateUtil.getFactory();
	
	@Override
	public List<Category> getAllCategory() {
		List<Category> categories= null;
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. query
			Query q = session.createQuery("FROM Category"); // class Category đại diện cho table
			categories = q.list();

			tx.commit();

			// 4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public boolean deleteCategory(int idCategory) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. delete
			Category category = findCategoryById(idCategory);
			session.delete(category);
			
			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. update
			Category newCategory = (Category) session.get(Category.class, category.getId());
			newCategory.setName(category.getName());
            
			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int insertCategory(Category category) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. insert

			session.save(category);
			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category.getId();
	}
	@Override
	public Category findCategoryById(int find_id) {
        Category findCategory = null;
        try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. find id
			findCategory = (Category) session.load(Category.class, find_id);
			
			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return findCategory;
    }
}
