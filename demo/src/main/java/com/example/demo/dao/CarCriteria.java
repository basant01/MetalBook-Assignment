package com.example.demo.dao;



import java.util.List;

import com.example.demo.entity.CarEntity;

public interface CarCriteria
{
    List<CarEntity> meetCriteria(final List<CarEntity> drivers);
}
