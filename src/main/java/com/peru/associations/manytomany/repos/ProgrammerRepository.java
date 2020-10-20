package com.peru.associations.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.peru.associations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
