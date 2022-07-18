package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.DriverEntity;
import com.example.demo.enums.OnlineStatus;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, Long>{
	
	List<DriverEntity> findByOnlineStatus(OnlineStatus onlineStatus);

}
