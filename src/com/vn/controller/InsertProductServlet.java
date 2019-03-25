package com.vn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.dao.CategoryDAO;
import com.vn.dao.CategoryDAOImpl;
import com.vn.dao.ProductDAO;
import com.vn.dao.ProductDAOImpl;
import com.vn.entities.Category;
import com.vn.entities.Product;
import com.vn.util.HibernateUtil;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/product/create")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static SessionFactory factory = HibernateUtil.getFactory();
	ProductDAO productDAOImpl = new ProductDAOImpl();
	CategoryDAO categoryDAOImpl = new CategoryDAOImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> categories = categoryDAOImpl.getAllCategory();
		
		request.setAttribute("categoriesList", categories);
		
		request.getRequestDispatcher("createProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Product
		String nameProduct = request.getParameter("nameProduct");
		double price = Double.parseDouble(request.getParameter("price"));
		Product product = new Product();
		product.setName(nameProduct);
		product.setPrice(price);
		
		// Category
		int idCategory = Integer.parseInt(request.getParameter("idCategory"));
		Category category = categoryDAOImpl.findCategoryById(idCategory);
		
		product.setCategory(category);
		productDAOImpl.insertProduct(product);
		// doGet(request, response);
	}

}
