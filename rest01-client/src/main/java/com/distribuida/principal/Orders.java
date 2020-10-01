package com.distribuida.principal;

public class Orders {

	public Integer id;
	public String item;
	public double price;

	public Integer customerId;

	public Customer customer;

	public Orders() {

	}

	public Orders(String item, double price, Integer customerId, Customer customer) {
		this.item = item;
		this.price = price;
		this.customerId = customerId;
		this.customer = customer;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", item=" + item + ", price=" + price + ", customerId=" + customerId + "]"
				+ "Customer: " + customer;
	}

}
