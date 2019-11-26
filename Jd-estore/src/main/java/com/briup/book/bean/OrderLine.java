package com.briup.book.bean;

import java.io.Serializable;

public class OrderLine implements Serializable {
    private Integer id;

    private Integer num;

    private Double cost;

   
    
    private Book book;
    
 
    
    private OrderForm orderForm;
    
    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getCost() {
        return cost;
    }

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", cost=" + cost + ", book=" + book + ", orderForm=" + orderForm
				+ "]";
	}

    



   
}