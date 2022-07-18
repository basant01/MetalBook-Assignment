package com.example.demo.dao;

import com.example.demo.entity.Filter;
import com.example.demo.enums.CriteriaType;
import com.jayway.jsonpath.InvalidCriteriaException;

public class CriteriaBuilder {
    static CarCriteria rootCriteria = null;

    public static CarCriteria build(Filter node) throws InvalidCriteriaException {


        if (node == null) {
            return null;
        }

        if (CriteriaType.AND == node.getCriteriaType()) {
            if (node.getOtherCriteria() != null) {
                CarCriteria criteria2 = build(node.getOtherCriteria());
              
            }

        } else if (CriteriaType.OR == node.getCriteriaType()) {
         
            if (node.getOtherCriteria() != null) {
                CarCriteria criteria2 = build(node.getOtherCriteria());
             
            }

        } else {
         
        }

        return rootCriteria;
    }

  


}
