package com.briup.book.servise.interf;

import org.apache.ibatis.session.SqlSession;

import com.briup.book.bean.OrderForm;
import com.briup.book.mapper.OrderFormMapper;
import com.briup.book.servise.impl.iOrderFormService;
import com.briup.book.util.MyBatisSqlSessionFactory;
import com.briup.book.util.ServiceException;

public class OrderFormService implements iOrderFormService {
	private static OrderFormMapper mapper;
	static {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession(true);
		mapper = openSession.getMapper(OrderFormMapper.class);
	}
	@Override
	public void saveOrderForm(OrderForm order) throws ServiceException {
		mapper.insert(order);
		
	}

}
