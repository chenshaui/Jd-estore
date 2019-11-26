package com.briup.book.web.servlet;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.book.bean.OrderLine;
import com.briup.book.bean.ShopCar;

/**
 * Servlet implementation class UpdateShopCarServlet
 */
@WebServlet("/updateShopCarServlet")
public class UpdateShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		int i = Integer.parseInt(num);
		int d = Integer.parseInt(id);
		HttpSession session = request.getSession();
		ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");
		Map<Integer, OrderLine> line = shopCar.getLine();
		Set<Integer> set = line.keySet();
		for (Integer integer : set) {
			if(integer == d) {
				OrderLine orderLine = line.get(d);
				orderLine.setNum(i);
			}
		}
		request.getRequestDispatcher("/WEB-INF/user/shopCar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
