package com.briup.book.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.book.bean.Customer;
import com.briup.book.bean.CustomerExample;
import com.briup.book.bean.CustomerExample.Criteria;
import com.briup.book.mapper.CustomerMapper;
import com.briup.book.util.MyBatisSqlSessionFactory;

/**
 * Servlet Filter implementation class CustomerFilter
 */
@WebFilter("/user/*")
public class CustomerFilter implements Filter {
	private static CustomerMapper customerMapper;
	static {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		customerMapper = sqlSession.getMapper(CustomerMapper.class);
		
	}
    /**
     * Default constructor. 
     */
    public CustomerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object attribute = session.getAttribute("customer");
		if(attribute != null) {
			chain.doFilter(req, resp);
			return ;
		} else {
			req.getRequestDispatcher("/doIndexServlet").forward(req, resp);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
