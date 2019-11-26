package com.briup.book.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.book.bean.Book;
import com.briup.book.servise.impl.BookNameImpl;
import com.briup.book.util.ServiceException;

/**
 * Servlet implementation class ViewBookServlet
 */
@WebServlet("/viewBook")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		BookNameImpl nameImpl = new BookNameImpl();
		try {
			Book viewBook = nameImpl.selectBookMessage(Integer.parseInt(id));
			System.out.println(viewBook);
			request.getSession().setAttribute("viewBookMessage", viewBook);
			request.getRequestDispatcher("/WEB-INF/jsp/viewBook.jsp").forward(request, response);
		} catch (ServiceException e) {
			String message = e.getMessage();
			request.getSession().setAttribute("viewBookMsg", message);
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
