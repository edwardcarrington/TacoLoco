package com.detroitlabs.tacoloco.tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.detroitlabs.tacoloco.TacoLocoRestController;
import com.google.gson.Gson;

class TacoLocoRestControllerTest {

	@Test
	void contextLoads() {
	}

	// For REST service
	@Test
	void inventoryValueIncludingDiscount() {

		TacoLocoRestController testOne = new TacoLocoRestController();
		String order = "[{'menuItem':'Veggie Taco','price':2.5,'quantity':10},{'menuItem':'Chicken Taco','price':3.0,'quantity':14},{'menuItem':'Beef Taco','price':3.0,'quantity':13},{'menuItem':'Chorizo Taco','price':3.5,'quantity':4}]";
		String expected = "{\"grandTotal\":96.0}";

		Gson gson = new Gson();

		String actual = gson.toJson(testOne.caculateTotal(order));
		assertEquals(expected, actual);
	}

	@Test
	void inventoryValueNotIncludingDiscount() {

		TacoLocoRestController testTwo = new TacoLocoRestController();
		String order = "[{'menuItem':'Veggie Taco','price':2.5,'quantity':10},{'menuItem':'Chicken Taco','price':3.0,'quantity':14},{'menuItem':'Beef Taco','price':3.0,'quantity':13},{'menuItem':'Chorizo Taco','price':3.5,'quantity':4}]";
		String unexpected = "{\"grandTotal\":120.0}";

		Gson gson = new Gson();

		String actual = gson.toJson(testTwo.caculateTotal(order));
		assertNotEquals(unexpected, actual);
	}

	@Test
	void outOfStockInventoryValue() {

		// Testing for discount
		TacoLocoRestController testThree = new TacoLocoRestController();
		String order = "[{'menuItem':'Veggie Taco','price':2.5,'quantity':0},{'menuItem':'Chicken Taco','price':3.0,'quantity':0},{'menuItem':'Beef Taco','price':3.0,'quantity':0},{'menuItem':'Chorizo Taco','price':3.5,'quantity':0}]";
		String unexpected = "{\"grandTotal\":0}";

		Gson gson = new Gson();

		String actual = gson.toJson(testThree.caculateTotal(order));
		assertNotEquals(unexpected, actual);
	}
}
