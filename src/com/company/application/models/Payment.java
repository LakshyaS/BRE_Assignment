package com.company.application.models;

public class Payment {

	private int id;
	private Order item;
	private int amount;

	public Payment(Order item) {
		this.item = item;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getItem() {
		return item;
	}

	public void setItem(Order item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", item=" + item + ", amount=" + amount + "]";
	}

}
