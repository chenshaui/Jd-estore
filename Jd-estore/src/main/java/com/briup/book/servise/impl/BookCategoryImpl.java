package com.briup.book.servise.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.briup.book.bean.Book;
import com.briup.book.bean.BookExample;
import com.briup.book.bean.Category;
import com.briup.book.bean.CategoryExample;
import com.briup.book.bean.CategoryExample.Criteria;
import com.briup.book.mapper.BookMapper;
import com.briup.book.mapper.CategoryMapper;
import com.briup.book.servise.interf.iBookCategory;
import com.briup.book.util.MyBatisSqlSessionFactory;
import com.briup.book.util.ServiceException;

/**
 * 
 * @ClassName:  BookCategoryImpl   
 * @Description:查询书籍种类
 * @author: chens@briup.com 
 * @date:   2019年10月23日 下午7:30:01   
 *     
 * @Copyright: 2019 www.briup.com All rights reserved.
 */
public class BookCategoryImpl implements iBookCategory {
	private static CategoryMapper categoryMapper = null;
	private static BookMapper bookMapper = null;
	
	static {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		categoryMapper = sqlSession.getMapper(CategoryMapper.class);
		bookMapper = sqlSession.getMapper(BookMapper.class);
	}

	@Override
	public List<Category> findFirstCategorys() throws ServiceException {
		List<Category> list = categoryMapper.findFirstCategory();
		return list;
	}

	@Override
	public Category getParentname(int id) throws ServiceException {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<Category> list = categoryMapper.selectByExample(example);
		if(list.isEmpty()) {
			throw new ServiceException("未知错误");
		} else {
			return list.get(0);
		}
		
	}

	
	
	

}
