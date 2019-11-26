package com.briup.book.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderForm implements Serializable {
    private Integer id;

    private Double cost;

    private Date orderdate;

    private ShopAddress shopaddress;

    private Customer customer;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

	public ShopAddress getShopaddress() {
		return shopaddress;
	}

	public void setShopaddress(ShopAddress shopaddress) {
		this.shopaddress = shopaddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", cost=" + cost + ", orderdate=" + orderdate + ", shopaddress=" + shopaddress
				+ ", customer=" + customer + "]";
	}


  

  
}