package com.example.demo.dao;

import com.example.demo.entity.Filter;
import com.example.demo.enums.CriteriaType;


public class DriverCriteriaBuilder {
    static DriverCriteria rootCriteria = null;

    public static DriverCriteria build(Filter node) throws Exception {


        if (node == null) {
            return null;
        }

        if (CriteriaType.AND == node.getCriteriaType()) {
            if (node.getOtherCriteria() != null) {
                DriverCriteria criteria2 = build(node.getOtherCriteria());
             
            }

        } else if (CriteriaType.OR == node.getCriteriaType()) {
            if (node.getOtherCriteria() != null) {
                DriverCriteria criteria2 = build(node.getOtherCriteria());
         
            }

        }else {
        	
        }

        return rootCriteria;
    }

}
