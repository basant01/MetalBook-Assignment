package com.example.demo.controller;

import java.sql.Driver;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.DriverService;
import com.example.demo.dao.DriverCriteria;
import com.example.demo.dao.DriverCriteriaBuilder;
import com.example.demo.entity.CarEntity;
import com.example.demo.entity.DriverEntity;
import com.example.demo.entity.Filter;
import com.example.demo.enums.OnlineStatus;

@RestController
@RequestMapping("demo/drivers")
public class DriverController {

	@Autowired
	DriverService driverService;
	
	@GetMapping("/{driverId}")	
	public DriverEntity getDriver(@PathVariable long driverId) throws Exception
	{
		return driverService.find(driverId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DriverEntity createDriver(@RequestBody DriverEntity driverEntity)
	{
		return driverService.create(driverEntity);
	}

	@DeleteMapping("/{cardId}")
	public void deleteDriver(@PathVariable long driverId) throws Exception
	{
		 driverService.delete(driverId);
	}


	@GetMapping
	public List<DriverEntity> findDrivers(@RequestParam OnlineStatus onlineStatus){
		return driverService.findall(onlineStatus);
	}
	
	@PostMapping("/{driverId}")
	public void selectCar(@PathVariable long driverId,@PathVariable Integer carId ) throws Exception {
	  driverService.selectCar(driverId,carId);
	}
	
	
	@PostMapping("/{carId}")
	public void deSelectCar(@PathVariable long driverId,@PathVariable Integer carId ) throws Exception {
		 driverService.deSelectCar(driverId,carId);
	}


	    @PutMapping
	    public DriverEntity assignCarToDriver(@RequestParam Long carId, @RequestParam Long driverId) throws Exception {
	        return driverService.assignRideToDriver(carId, driverId);
	    }

	    @PutMapping("/unassignDriver{/driverId}")
	    public DriverEntity unassignCarFromDriver(@RequestParam Long driverId) throws Exception {
	        return driverService.unassignRideFromDriver(driverId);
	    }

	    @PostMapping("/filter")
	    public List<DriverEntity> filterDrivers( @RequestBody Filter filterCriteria) throws Exception {
	        DriverCriteria driverCriteria = DriverCriteriaBuilder.build(filterCriteria);
	        return driverService.findByCriteria(driverCriteria);
	    }
}
