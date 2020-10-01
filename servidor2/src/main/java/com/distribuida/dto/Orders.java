package com.distribuida.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Orders extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	public String item;
	public double price;
	@Column(name = "customer_id")
	public Integer customerId;
	@Transient
	public Customer customer;

	public Orders() {

	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", item=" + item + ", price=" + price + ", customerId=" + customerId + "]"
				+ "Customer: " + customer;
	}

}
