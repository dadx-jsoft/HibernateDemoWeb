package com.vn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.dao.CategoryDAO;
import com.vn.dao.CategoryDAOImpl;
import com.vn.dao.ProductDAO;
import com.vn.dao.ProductDAOImpl;
import com.vn.dao.ProductDetailDAO;
import com.vn.dao.ProductDetailDAOImpl;
import com.vn.entities.Category;
import com.vn.entities.Product;
import com.vn.entities.ProductDetail;

/**
 * Servlet implementation class AddDescriptionProduct
 */
@WebServlet("/AddDescriptionProduct")
public class AddDescriptionProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductDAO productDAOImpl = new ProductDAOImpl();
	ProductDetailDAO productDetailDAOImpl = new ProductDetailDAOImpl();
	CategoryDAO categoryDAOImpl = new CategoryDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDescriptionProduct() {
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

		request.getRequestDispatcher("addDescriptionProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nameProduct = request.getParameter("nameProduct");
		double price = Double.parseDouble(request.getParameter("price"));
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		int idCategory = Integer.parseInt(request.getParameter("idCategory"));

		ProductDetail productDetail = new ProductDetail();
		productDetail.setDescription(description);
		productDetail.setContent(content);

		Category category = categoryDAOImpl.findCategoryById(idCategory);

		Product product = new Product();
		product.setName(nameProduct);
		product.setPrice(price);
		product.setCategory(category);

		product.setProductDetail(productDetail);

		productDetail.setProduct(product);

		productDAOImpl.insertProduct(product);
		productDetailDAOImpl.insertProductDetail(productDetail);
	}

}
