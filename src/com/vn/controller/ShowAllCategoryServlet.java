package com.vn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.dao.CategoryDAO;
import com.vn.dao.CategoryDAOImpl;
import com.vn.entities.Category;

/**
 * Servlet implementation class ShowAllCategoryServlet
 */
@WebServlet("/category/showAll")
public class ShowAllCategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	CategoryDAO categoryDAOImpl = new CategoryDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAllCategoryServlet() {
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

		List<Category> categories = categoryDAOImpl.getAllCategory();

		for (Category category : categories) {
			writer.println(category.getName() + "</br>");
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
