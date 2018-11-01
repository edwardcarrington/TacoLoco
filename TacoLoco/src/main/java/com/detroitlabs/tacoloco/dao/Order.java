package com.detroitlabs.tacoloco.dao;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Order {

	private List<Item> items;
	private double discount = .8;
	private boolean applyDiscount = false;

	public Order() {
	}

	public Order(List<Item> items) {
		this.items = items;
	}

	public Order(String placedOrder) {
		Gson gson = new Gson();

		Type deserializationType = new TypeToken<ArrayList<Item>>() {
		}.getType();

		this.items = gson.fromJson(placedOrder, deserializationType);
	}

	public GrandTotal getGrandTotal() {
		double subTotal = getSubTotal();

		if (applyDiscount == true) {
			subTotal = applyDiscount(subTotal);
		}

		return new GrandTotal(subTotal);
	}

	public double getSubTotal() {

		double subTotal = 0;

		for (Item item : items) {
			double lineItem = item.getPrice() * item.getQuantity();
			subTotal = subTotal + lineItem;

			if (item.getQuantity() > 4 || items.size() > 4) {
				applyDiscount = true;
			}

		}
		return subTotal;
	}

	public double applyDiscount(double originalTotal) {
		return originalTotal * discount;
	}

}
