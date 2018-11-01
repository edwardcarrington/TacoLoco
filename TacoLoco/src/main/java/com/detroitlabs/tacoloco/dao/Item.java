package com.detroitlabs.tacoloco.dao;

public class Item {

	private String menuItem;
	private Double price;
	private Integer quantity;

	public Item() {
	}

	public Item(String menuItem, Double price, Integer quantity) {
		super();
		this.menuItem = menuItem;
		this.price = price;
		this.quantity = quantity;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
