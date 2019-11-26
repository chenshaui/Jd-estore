package com.briup.book.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShopCar {
	private Map<Integer, OrderLine> map;
	
	public ShopCar() {
		map = new HashMap<>();
	}
	
	public void add(OrderLine orderLine) {
		int num = orderLine.getNum();
		Integer bookid = orderLine.getBook().getId();
		if(map.containsKey(bookid)) {
			OrderLine orderLine2 = map.get(bookid);
			Integer num2 = orderLine2.getNum();
			num += num2;
			map.put(num, orderLine);
		} else {
			map.put(bookid, orderLine);
		}
		
	}
	
	/**
	 * 
	 * <p>Title: clear</p>  
	 * <p>Description: 清空</p> 
	 *
	 */
	public void clear() {
		map.clear();
	}
	
	public int getSumNum() {
		int sumNum = 0;
		Set<Integer> keySet = map.keySet();
		for (Integer integer : keySet) {
			OrderLine orderLine = map.get(integer);
			sumNum += orderLine.getNum();
		}
		return sumNum;
	}
	
	public double getCost() {
		double cost = 0.0;
		Set<Integer> keySet = map.keySet();
		for (Integer integer : keySet) {
			OrderLine orderLine = map.get(integer);
			Integer num = orderLine.getNum();
			Double price = orderLine.getBook().getPrice();
			cost += num * price;
		}
		return cost;
	} 
	
	
	public Map<Integer, OrderLine> getLine() {
		
		return map;
	}
}
