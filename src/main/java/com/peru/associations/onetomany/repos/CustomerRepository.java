package com.peru.associations.onetomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.peru.associations.onetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
