package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CarCriteria;
import com.example.demo.entity.CarEntity;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	
	public CarEntity find(Long carId) throws Exception {
		return carRepository.findById(carId).orElseThrow(()->new Exception("Could not find id"));
	
	}
	
	public CarEntity create(CarEntity carEntity)
	{
		CarEntity carE;
		carE= carRepository.save(carEntity);
		return carE;
	
	}
	
	@Transactional
	public void delete(Long carId) throws Exception {
		CarEntity carEntity= carRepository.findById(carId).orElseThrow(()->new Exception("Could not find id"));
	}
	  
	    public List<CarEntity> getCars() {
	        return (List<CarEntity>) carRepository.findAll();
	    }

	 
	    public List<CarEntity> findByCriteria(CarCriteria criteria) {
	        List<CarEntity> cars;
	        cars = (List<CarEntity>) carRepository.findAll();
	        if(criteria==null){
	            return cars;
	        }
	        return criteria.meetCriteria(cars);
	    }
}
