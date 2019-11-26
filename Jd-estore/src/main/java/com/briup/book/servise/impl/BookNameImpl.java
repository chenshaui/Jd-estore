package com.briup.book.servise.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.book.bean.Book;
import com.briup.book.bean.BookExample;
import com.briup.book.bean.BookExample.Criteria;
import com.briup.book.bean.CategoryExample;
import com.briup.book.mapper.BookMapper;
import com.briup.book.servise.interf.IBookNameServise;
import com.briup.book.util.MyBatisSqlSessionFactory;
import com.briup.book.util.ServiceException;

public class BookNameImpl implements IBookNameServise {
	private static BookMapper bookMapper;
	
	static {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession(true);
		bookMapper = openSession.getMapper(BookMapper.class);
	}
	/**
	 * 查询所有书籍
	 */
	@Override
	public List<Book> selectBookName() throws ServiceException {
		BookExample bookExample = new BookExample();
		Criteria criteria = bookExample.createCriteria();
		criteria.andIdIsNotNull();
		List<Book> list = bookMapper.selectByExample(bookExample);
		if(list.isEmpty()) {
			throw new ServiceException("暂无书籍");
		} else {
			return list;
		}
	}
	/**
	 * 查询最新书籍
	 */
	@Override
	public List<Book> selectNewBook() throws ServiceException {
		List<Book> books = bookMapper.selectNewBooks();
		if(books.isEmpty()) {
			throw new ServiceException("暂无最新书籍");
		} else {
			return books;
		}
	}
	/**
	 * 查询书籍具体信息
	 */
	@Override
	public Book selectBookMessage(int id) throws ServiceException {
		BookExample bookExample = new BookExample();
		Criteria criteria = bookExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<Book> list = bookMapper.selectByExample(bookExample);
		if(list.isEmpty()) {
			throw new ServiceException("此商品暂不存在");
		} else {
			return list.get(0);
		}
	}
	/**
	 * 查询指定类型所有书籍
	 */
	@Override
	public List<Book> selectSameBook(int id) throws ServiceException {
		BookExample bookExample = new BookExample();
		Criteria criteria = bookExample.createCriteria();
		criteria.andCategoryIdEqualTo(id);
		List<Book> list = bookMapper.selectByExample(bookExample);
		if(list.isEmpty()) {
			throw new ServiceException("本类暂无其他书籍");
		} else {
			return list;
		}
	}
	

}
