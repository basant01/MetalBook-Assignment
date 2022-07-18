package com.example.demo.dao;



import java.util.List;

import com.example.demo.entity.CarEntity;

public class AndCarCriteria implements CarCriteria
{

    private CarCriteria criteria;
    private CarCriteria otherCriteria;


    public AndCarCriteria(CarCriteria criteria, CarCriteria otherCriteria)
    {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }


    @Override
    public List<CarEntity> meetCriteria(List<CarEntity> cars)
    {
        List<CarEntity> firstCriteriaItems = criteria.meetCriteria(cars);
        return otherCriteria.meetCriteria(firstCriteriaItems);

    }

}
