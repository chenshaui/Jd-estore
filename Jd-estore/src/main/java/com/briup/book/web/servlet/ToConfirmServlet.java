package com.briup.book.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.book.bean.Customer;
import com.briup.book.bean.OrderForm;
import com.briup.book.bean.ShopCar;
import com.briup.book.servise.interf.OrderFormService;
import com.briup.book.util.ServiceException;



/**
 * 
 * @ClassName:  ToConfirmServlet   
 * @Description:提交订单
 * @author: chens@briup.com 
 * @date:   2019年10月25日 下午4:19:34   
 *     
 * @Copyright: 2019 www.briup.com All rights reserved.
 */
@WebServlet("/user/toConfirmServlet")
public class ToConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		ShopCar shop = (ShopCar) session.getAttribute("shopCar");
		OrderForm orderForm = new OrderForm();
		orderForm.setCost(shop.getCost());
		orderForm.setCustomer(customer);
		orderForm.setOrderdate(new Date());
		OrderFormService orderFormService = new OrderFormService();
		try {
			orderFormService.saveOrderForm(orderForm);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/user/confirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
