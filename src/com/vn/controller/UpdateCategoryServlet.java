package com.vn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.dao.CategoryDAO;
import com.vn.dao.CategoryDAOImpl;
import com.vn.entities.Category;

/**
 * Servlet implementation class UpdateCategoryServlet
 */
@WebServlet("/category/update")
public class UpdateCategoryServlet extends HttpServlet {
	CategoryDAO categoryDAOImpl = new CategoryDAOImpl(); 
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCategoryServlet() {
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
		request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("idCategory"));
		String name = request.getParameter("nameCategory");
		
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		
		categoryDAOImpl.updateCategory(category);
		request.setAttribute("categoryName", category);
		
		request.getRequestDispatcher("/category/hienThi.jsp").forward(request, response);
		// request.getRequestDispatcher("hienThi.jsp").forward(request, response);
	}

}
