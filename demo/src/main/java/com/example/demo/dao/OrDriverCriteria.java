package com.example.demo.dao;

import com.example.demo.entity.DriverEntity;
import java.util.List;

public class OrDriverCriteria implements DriverCriteria {
    private DriverCriteria criteria;
    private DriverCriteria otherCriteria;

    public OrDriverCriteria(DriverCriteria criteria, DriverCriteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<DriverEntity> meetCriteria(List<DriverEntity> drivers) {
        List<DriverEntity> firstCriteriaItems = criteria.meetCriteria(drivers);
        List<DriverEntity> otherCrietriaItems = criteria.meetCriteria(drivers);
        for(DriverEntity driver:otherCrietriaItems){
            if(!firstCriteriaItems.contains(driver)){
                firstCriteriaItems.add(driver);
            }
        }
        return firstCriteriaItems;
    }
}
