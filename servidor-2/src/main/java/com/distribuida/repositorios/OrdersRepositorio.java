package com.distribuida.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.distribuida.dto.Orders;

@Repository
public interface OrdersRepositorio extends CrudRepository<Orders, Integer> {

}
