package com.briup.book.servise.impl;

import com.briup.book.bean.OrderForm;
import com.briup.book.util.ServiceException;

public interface iOrderFormService  {
	void saveOrderForm(OrderForm O) throws ServiceException;
}
