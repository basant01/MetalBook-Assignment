package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CarEntity;

@Repository
public interface CarRepository  extends CrudRepository<CarEntity, Long>{

}
