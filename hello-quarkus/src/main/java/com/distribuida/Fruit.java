package com.distribuida;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity

@Table(name = "fruit")
public class Fruit extends PanacheEntityBase {
	@Id
	public Integer id;
	public String name;
	public String description;

	public Fruit() {
	}

	public Fruit(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
