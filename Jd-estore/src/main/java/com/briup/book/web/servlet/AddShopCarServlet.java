package com.briup.book.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.book.bean.Book;
import com.briup.book.bean.OrderLine;
import com.briup.book.bean.ShopCar;
import com.briup.book.servise.impl.BookCategoryImpl;
import com.briup.book.servise.impl.BookNameImpl;
import com.briup.book.util.ServiceException;

/**
 * 
 * @ClassName:  AddShopCarServlet   
 * @Description:添加购物车
 * @author: chens@briup.com 
 * @date:   2019年10月25日 上午11:24:35   
 *     
 * @Copyright: 2019 www.briup.com All rights reserved.
 */
@WebServlet("/user/addShopCarServlet")
public class AddShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		int parseInt = Integer.parseInt(id);
		int parseInt2 = Integer.parseInt(num);
		BookNameImpl bookNameImpl = new BookNameImpl();
		try {
			Book book = bookNameImpl.selectBookMessage(parseInt);
			OrderLine orderLine = new OrderLine();
			orderLine.setBook(book);
			orderLine.setNum(parseInt2);
			ShopCar shopCar = (ShopCar) request.getSession().getAttribute("shopCar");
			shopCar.add(orderLine);
			request.getRequestDispatcher("/WEB-INF/user/shopCart.jsp").forward(request, response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
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
