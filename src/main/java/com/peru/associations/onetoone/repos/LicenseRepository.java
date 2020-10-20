package com.peru.associations.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.peru.associations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License, Integer>{

}
