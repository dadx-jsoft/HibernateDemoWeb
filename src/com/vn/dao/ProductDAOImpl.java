package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.vn.entities.Product;
import com.vn.util.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	final static SessionFactory factory = HibernateUtil.getFactory();

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = null;
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. query
			Query q = session.createQuery("FROM Product"); // class Product đại diện cho table
			products = q.list();

			tx.commit();
//			for (Product product : products) {
//				writer.println("<h1>"+ product.getName() + "</h1>");
//			}

			// 4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public boolean deleteProduct(int idProduct) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. delete
			Product product = findRecordById(idProduct);
			session.delete(product);

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
	public boolean updateProduct(Product product) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. update
			Product newProduct = (Product) session.get(Product.class, product.getId());
			newProduct.setName(product.getName());

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
	public int insertProduct(Product product) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. insert

			session.save(product);
			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product.getId();
	}

	public static Product findRecordById(int find_product_id) {
		Product findProductObj = null;
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. find id
			findProductObj = (Product) session.load(Product.class, find_product_id);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findProductObj;
	}
}
