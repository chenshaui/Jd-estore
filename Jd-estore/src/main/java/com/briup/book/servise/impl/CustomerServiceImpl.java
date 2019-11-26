package com.briup.book.servise.impl;

import java.util.List;

import javax.servlet.ServletException;
import org.apache.ibatis.session.SqlSession;
import com.briup.book.bean.Customer;
import com.briup.book.bean.CustomerExample;
import com.briup.book.bean.CustomerExample.Criteria;
import com.briup.book.mapper.CustomerMapper;
import com.briup.book.servise.interf.iCustomerServise;
import com.briup.book.util.MyBatisSqlSessionFactory;
import com.briup.book.util.ServiceException;

public class CustomerServiceImpl implements iCustomerServise {
	private static CustomerMapper customerMapper = null;
	static {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		customerMapper = sqlSession.getMapper(CustomerMapper.class);
	}
	@Override
	public Customer login(String name, String password) throws ServiceException {
		CustomerExample customerExample = new CustomerExample();
		Criteria criteria = customerExample.createCriteria();
		criteria.andNameEqualTo(name).andPasswordEqualTo(password);
		
		List<Customer> selectByExample = customerMapper.selectByExample(customerExample);
		if(selectByExample.isEmpty()) {
			throw new ServiceException("账号密码有误");
		} else {
			return selectByExample.get(0);
		}
	}
	@Override
	public void register(Customer customer) throws ServiceException {
		CustomerExample customerExample = new CustomerExample();
		Criteria criteria = customerExample.createCriteria();
		criteria.andNameEqualTo(customer.getName());
		List<Customer> example = customerMapper.selectByExample(customerExample);
		if(example.isEmpty()) {
			customerMapper.insert(customer);
		} else {
			throw new ServiceException("用户已经存在");
		}
	}
	
	

}
