package com.briup.book.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.book.bean.Customer;
import com.briup.book.bean.ShopCar;
import com.briup.book.servise.impl.CustomerServiceImpl;
import com.briup.book.util.ServiceException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		try {
			Customer login = customerServiceImpl.login(name, password);
			HttpSession session = request.getSession();
			session.setAttribute("customer", login);
			ShopCar shopCar = new ShopCar();
			request.getSession().setAttribute("shopCar", shopCar);
			request.getRequestDispatcher("/categoryServlet").forward(request, response);
		} catch (ServiceException e) {
			String message = e.getMessage();
			HttpSession session = request.getSession();
			session.setAttribute("loginmsg", message);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			e.printStackTrace();
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
