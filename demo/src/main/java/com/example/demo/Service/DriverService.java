package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DriverCriteria;
import com.example.demo.entity.CarEntity;
import com.example.demo.entity.DriverEntity;
import com.example.demo.enums.OnlineStatus;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.DriverRepository;

@Service
public class DriverService {
	
@Autowired	
private DriverRepository driverRepository;
	
@Autowired 
private CarRepository carRepository;
	
	public DriverEntity find(Long driverId) throws Exception {
		return driverRepository.findById(driverId).orElseThrow(()->new Exception("Could not find id"));
	
	}
	
	public DriverEntity create(DriverEntity driverEntity)
	{
		DriverEntity driverE;
		driverE= driverRepository.save(driverEntity);
		return driverE;
	
	}
	
	@Transactional
	public void delete(Long driverId) throws Exception {
		DriverEntity driverEntity= driverRepository.findById(driverId).orElseThrow(()->new Exception("Could not find id"));
	}
	
	
	
	@Transactional
	public void selectCar(Long driverId, Integer carId) throws Exception
	{
		DriverEntity driverEntity= driverRepository.findById(driverId).orElseThrow(()->new Exception("Could not find id"));	
	  if(driverEntity.getCarIdSelect()!=null) {
		  throw new Exception();
	  }
	  driverEntity.setCarIdSelect(carId);
	}
	
	
	@Transactional
	public void deSelectCar(Long driverId, Integer carId) throws Exception
	{
		DriverEntity driverEntity= driverRepository.findById(driverId).orElseThrow(()->new Exception("Could not find id"));
	  driverEntity.setCarIdSelect(null);
	}
	
	public List<DriverEntity> findall(OnlineStatus onlineStatus)
	{
		return driverRepository.findByOnlineStatus(onlineStatus);
	}
	

	@Transactional
	    public DriverEntity assignRideToDriver(Long carId, Long driverId) throws Exception {
		CarEntity car = carRepository.findById(carId).orElseThrow(()->new Exception("Could not find id"));
		
	        if (car == null) {
	            throw new Exception("car not found or already assigned " + carId);
	        }
	        DriverEntity driver = driverRepository.findById(driverId).orElseThrow(()->new Exception("Could not find id"));
	        if(car.getDriverEntity()!=null && car.getDriverEntity().getDriverId()!=driverId){
	            throw new Exception("car is already assigned to another driver"+carId);
	        }
	        if(driver.getCarEntity()!= null){
	            //if there is a car already assigned to driver, first need to be un assigned
	            unassignCar(driver.getCarEntity().getId());
	        }
	        driver.setCarEntity(car);
	        driverRepository.save(driver);
	        return driver;

	    }

	 
	    public DriverEntity unassignRideFromDriver(Long driverId) throws Exception {
	        DriverEntity driver = driverRepository.findById(driverId).orElseThrow(()->new Exception("Could not find id"));
	        if(driver.getCarEntity()!=null) {
	            Long carId = driver.getCarEntity().getId();
	            unassignCar(carId);
	        }
	        driver.setCarEntity(null);
	        driverRepository.save(driver);
	        return driver;
	    }


	    private void unassignCar(Long carId) throws Exception{
	        
	        CarEntity car = carRepository.findById(carId).orElseThrow(()->new Exception("Could not find id"));
	        car.setDriverEntity(null);
	        carRepository.save(car);
	   
	    }
	    public List<DriverEntity> findByCriteria(DriverCriteria criteria) {
	        List<DriverEntity> drivers = (List<DriverEntity>) driverRepository.findAll();
	        if(criteria==null){
	            return drivers;
	        }
	        return criteria.meetCriteria(drivers);
	    }

}
