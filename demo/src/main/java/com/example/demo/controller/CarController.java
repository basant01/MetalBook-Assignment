package com.example.demo.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CarService;
import com.example.demo.entity.CarEntity;
import com.example.demo.entity.Filter;
import com.example.demo.dao.*;

@RestController
@RequestMapping("demo/cars")
public class CarController {

	@Autowired
	CarService carService;
	
@GetMapping("/{carId}")	
public CarEntity getCar(@PathVariable long cardId) throws Exception
{
	return carService.find(cardId);
}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public CarEntity createCar(@RequestBody CarEntity carEntity)
{
	return carService.create(carEntity) ;
}

@DeleteMapping("/{cardId}")
public void deleteCar(@PathVariable long cardId) throws Exception
{
	carService.delete(cardId);
}


@PostMapping("/filter")
public List<CarEntity> filterCars( @RequestBody Filter filterCriteria) {
    CarCriteria criteria = CriteriaBuilder.build(filterCriteria);
    return carService.findByCriteria(criteria);

}

}
