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
 * Servlet implementation class InsertCategoryServlet
 */
@WebServlet("/category/create")
public class InsertCategoryServlet extends HttpServlet {
	CategoryDAO categoryDAOImpl = new CategoryDAOImpl(); 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("createCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nameCategory = request.getParameter("nameCategory");
		Category category = new Category();
		category.setName(nameCategory);
		categoryDAOImpl.insertCategory(category);
		
		
//		doGet(request, response);
	}

}
