package com.briup.book.servise.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.briup.book.bean.OrderLine;
import com.briup.book.bean.OrderLineExample;
import com.briup.book.bean.OrderLineExample.Criteria;
import com.briup.book.mapper.OrderLineMapper;
import com.briup.book.servise.interf.iShopCarService;
import com.briup.book.util.MyBatisSqlSessionFactory;

public class ShopCarServiceImpl implements iShopCarService {
	private static OrderLineMapper orderLineMapper;
	
	static {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession(true);
		orderLineMapper = openSession.getMapper(OrderLineMapper.class);
	}
	@Override
	public List<OrderLine> selectShopCar() {
		OrderLineExample lineExample = new OrderLineExample();
		Criteria criteria = lineExample.createCriteria();
		criteria.andBookIdIsNotNull();
		List<OrderLine> list = orderLineMapper.selectByExample(lineExample);
		return list;
	}

}
