package com.vn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.dao.ProductDAO;
import com.vn.dao.ProductDAOImpl;
import com.vn.entities.Product;

/**
 * Servlet implementation class ShowAllCategoryServlet
 */
@WebServlet("/products")
public class ShowAllProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	ProductDAO productDAOImpl = new ProductDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAllProductServlet() {
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
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		List<Product> products = productDAOImpl.getAllProduct();

		for (Product product : products) {
			writer.print(product.getName()+"</br>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
