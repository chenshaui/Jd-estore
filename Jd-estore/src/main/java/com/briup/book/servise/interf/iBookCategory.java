package com.briup.book.servise.interf;

import com.briup.book.bean.Category;
import com.briup.book.util.ServiceException;

import java.util.List;
/**
 * 
 * @ClassName:  iBookCategory   
 * @Description:书籍种类
 * @author: chens@briup.com 
 * @date:   2019年10月24日 上午9:52:18   
 *     
 * @Copyright: 2019 www.briup.com All rights reserved.
 */
public interface iBookCategory {
	 List<Category> findFirstCategorys() throws ServiceException;
	
	Category getParentname(int id) throws ServiceException;
}
