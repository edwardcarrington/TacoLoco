package com.detroitlabs.tacoloco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.detroitlabs.tacoloco.dao.Order;

class OrderTest {

	@Test
	void applyDiscountTest() {
		double expected = 0.80;
		Order order = new Order();
		double actual = order.applyDiscount(1.00);
		assertEquals(expected, actual);
	}

	@Test
	void getSubTobalTest() {
		double expected = 120;
		String placedOrder = "[{'menuItem':'Veggie Taco','price':2.5,'quantity':10},{'menuItem':'Chicken Taco','price':3.0,'quantity':14},{'menuItem':'Beef Taco','price':3.0,'quantity':13},{'menuItem':'Chorizo Taco','price':3.5,'quantity':4}]";
		Order order = new Order(placedOrder);
		double actual = order.getSubTotal();
		assertEquals(expected, actual);
	}

	@Test
	void getSubTotalTest2() {
		double expected = 105;
		String placedOrder = "[{'menuItem':'Veggie Taco','price':2.5,'quantity':4},{'menuItem':'Chicken Taco','price':3.0,'quantity':14},{'menuItem':'Beef Taco','price':3.0,'quantity':13},{'menuItem':'Chorizo Taco','price':3.5,'quantity':4}]";
		Order order = new Order(placedOrder);
		double actual = order.getSubTotal();
		assertEquals(expected, actual);
	}

	@Test
	void getGrandTotalTest() {
		double expected = 96;
		String placedOrder = "[{'menuItem':'Veggie Taco','price':2.5,'quantity':10},{'menuItem':'Chicken Taco','price':3.0,'quantity':14},{'menuItem':'Beef Taco','price':3.0,'quantity':13},{'menuItem':'Chorizo Taco','price':3.5,'quantity':4}]";
		Order order = new Order(placedOrder);
		double actual = order.getGrandTotal().getGrandTotal(); // method chaining
		assertEquals(expected, actual);
	}

}
