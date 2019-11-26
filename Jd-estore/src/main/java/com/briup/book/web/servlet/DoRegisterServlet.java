package com.briup.book.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import com.briup.book.bean.Customer;
import com.briup.book.servise.impl.CustomerServiceImpl;
import com.briup.book.util.ServiceException;

/**
 * Servlet implementation class DoRegisterServlet
 */
@WebServlet("/doRegisterServlet")
public class DoRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String zipcode = request.getParameter("zipCode");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setZipcode(zipcode);
		customer.setEmail(email);
		customer.setTelephone(telephone);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		try {
			customerServiceImpl.register(customer);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);;
		} catch (ServiceException e) {
			String message = e.getMessage();
			HttpSession session = request.getSession();
			session.setAttribute("msg", message);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);;
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
