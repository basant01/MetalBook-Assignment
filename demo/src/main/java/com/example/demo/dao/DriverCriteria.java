package com.example.demo.dao;



import java.util.List;

import com.example.demo.entity.DriverEntity;

public interface DriverCriteria {
    List<DriverEntity> meetCriteria(final List<DriverEntity> drivers);
}
