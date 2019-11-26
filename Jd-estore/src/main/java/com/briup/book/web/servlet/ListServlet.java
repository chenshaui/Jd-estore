package com.briup.book.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.book.bean.Book;
import com.briup.book.bean.Category;
import com.briup.book.servise.impl.BookCategoryImpl;
import com.briup.book.servise.impl.BookNameImpl;
import com.briup.book.util.ServiceException;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			BookNameImpl nameImpl = new BookNameImpl();
			BookCategoryImpl impl = new BookCategoryImpl();
			List<Book> list = nameImpl.selectSameBook(Integer.parseInt(id));
			Category category = impl.getParentname(Integer.parseInt(id));
			System.out.println(category.getName());
			request.getSession().setAttribute("parentCategoryName", category);
			request.getSession().setAttribute("listBook", list);
			request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
		} catch (ServiceException e) {
			String message = e.getMessage();
			request.getSession().setAttribute("noBookMsg", message);
			request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
