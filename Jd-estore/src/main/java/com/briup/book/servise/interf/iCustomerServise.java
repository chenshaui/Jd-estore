package com.briup.book.servise.interf;



import com.briup.book.bean.Customer;
import com.briup.book.util.ServiceException;
/**
 * 
 * @ClassName:  iCustomerServise   
 * @Description:用户表相关
 * @author: chens@briup.com 
 * @date:   2019年10月24日 上午9:52:35   
 *     
 * @Copyright: 2019 www.briup.com All rights reserved.
 */
public interface iCustomerServise {
	/**
	 * 
	 * <p>Title: login</p>  
	 * <p>Description: 登录</p> 
	 * 
	 * @param name
	 * @param pwaaword
	 */
	public Customer login(String name, String password) throws ServiceException;
	/**
	 * 
	 * <p>Title: register</p>  
	 * <p>Description:注册 </p> 
	 * 
	 * @param customer
	 */
	public void register(Customer customer) throws ServiceException;
	

	
	
}
