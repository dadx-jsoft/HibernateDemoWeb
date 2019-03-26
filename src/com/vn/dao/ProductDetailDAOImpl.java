package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.vn.entities.Product;
import com.vn.entities.ProductDetail;
import com.vn.util.HibernateUtil;

public class ProductDetailDAOImpl implements ProductDetailDAO{

	final static SessionFactory factory = HibernateUtil.getFactory();
	
	@Override
	public List<ProductDetail> getAllProductDetail() {
		List<ProductDetail> productDetails = null;
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. query
			Query q = session.createQuery("FROM ProductDetail"); // class Product đại diện cho table
			productDetails = q.list();

			tx.commit();
//			for (Product product : products) {
//				writer.println("<h1>"+ product.getName() + "</h1>");
//			}

			// 4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDetails;
	}

	@Override
	public boolean deleteProductDetail(int idProductDetail) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. delete
			Product product = findRecordById(idProductDetail);
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
	public boolean updateProductDetail(ProductDetail productDetail) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. update
			ProductDetail newProductDetail = (ProductDetail) session.get(ProductDetail.class, productDetail.getId());
			newProductDetail.setContent(productDetail.getContent());;

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
	public int insertProductDetail(ProductDetail productDetail) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. insert

			session.save(productDetail);
			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDetail.getId();
	}
	
	public static Product findRecordById(int find_product_detail_id) {
		Product findProductObj = null;
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. find id
			findProductObj = (Product) session.load(Product.class, find_product_detail_id);

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
