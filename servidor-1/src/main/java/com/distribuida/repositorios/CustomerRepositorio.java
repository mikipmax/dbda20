package com.distribuida.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.distribuida.dto.Customer;
@Repository
public interface CustomerRepositorio extends CrudRepository<Customer, Integer> {

}
