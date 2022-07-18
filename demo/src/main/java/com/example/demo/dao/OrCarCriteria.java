package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.CarEntity;

public class OrCarCriteria implements CarCriteria {
    private CarCriteria criteria;
    private CarCriteria otherCrietria;

    public OrCarCriteria(CarCriteria criteria, CarCriteria otherCrietria) {
        this.criteria = criteria;
        this.otherCrietria = otherCrietria;
    }

    @Override
    public List<CarEntity> meetCriteria(List<CarEntity> cars) {
        List<CarEntity> firstCriteriaItems = criteria.meetCriteria(cars);
        List<CarEntity> otherCrietriaItems = otherCrietria.meetCriteria(cars);

        for (CarEntity car : otherCrietriaItems) {
            if (!firstCriteriaItems.contains(car)) {
                firstCriteriaItems.add(car);
            }
        }
        return firstCriteriaItems;
    }
}
