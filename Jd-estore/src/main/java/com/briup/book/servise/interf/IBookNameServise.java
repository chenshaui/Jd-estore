package com.briup.book.servise.interf;

import java.util.List;

import com.briup.book.bean.Book;
import com.briup.book.util.ServiceException;

/**
 * 
 * @ClassName:  IBookNameServise   
 * @Description:book表相关
 * @author: chens@briup.com 
 * @date:   2019年10月24日 上午9:52:58   
 *     
 * @Copyright: 2019 www.briup.com All rights reserved.
 */
public interface IBookNameServise {
	List<Book> selectBookName() throws ServiceException;
	
	List<Book> selectNewBook() throws ServiceException;
	
	Book selectBookMessage(int id) throws ServiceException;
	
	List<Book> selectSameBook(int id) throws ServiceException;
	
	
}
