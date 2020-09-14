package com.company.application.models;

public class Order {

	private int itemId;
	private String itemName;

	public Order(String itemName) {
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Order [itemId=" + itemId + ", itemName=" + itemName + "]";
	}
}
