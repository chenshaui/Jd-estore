package com.briup.book.web.servlet;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.book.bean.Book;
import com.briup.book.bean.Category;
import com.briup.book.servise.impl.BookCategoryImpl;
import com.briup.book.servise.impl.BookNameImpl;
import com.briup.book.util.ServiceException;

/**
 * 
 * @ClassName:  FirstIndexServlet   
 * @Description:对首页信息展示筛选
 * @author: chens@briup.com 
 * @date:   2019年10月23日 下午6:49:21   
 *     
 * @Copyright: 2019 www.briup.com All rights reserved.
 */
@WebServlet("/categoryServlet")
public class CategotyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookCategoryImpl bookCategoryImpl = new BookCategoryImpl();
		BookNameImpl bookNameImpl = new BookNameImpl();
		
			try {
				List<Category> bookCategorys = bookCategoryImpl.findFirstCategorys();
				request.getSession().setAttribute("category", bookCategorys);
				List<Book> bookName = bookNameImpl.selectBookName();
				request.getSession().setAttribute("book", bookName);
				List<Book> newBook = bookNameImpl.selectNewBook();
				request.getSession().setAttribute("newBook", newBook);
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);;
			} catch (ServiceException e) {
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
