package com.example.demo.dao;


import java.util.List;

import com.example.demo.entity.DriverEntity;


public class AndDriverCriteria implements DriverCriteria {
    private DriverCriteria criteria;
    private DriverCriteria otherCriteria;

    public AndDriverCriteria(DriverCriteria criteria, DriverCriteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<DriverEntity> meetCriteria(List<DriverEntity> drivers) {
        List<DriverEntity> firstCriteriaItems = criteria.meetCriteria(drivers);
        return otherCriteria.meetCriteria(firstCriteriaItems);
    }
}
