package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.example.demo.enums.CriteriaType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filter {
  
    private CriteriaType criteriaType;
    public CriteriaType getCriteriaType() {
		return criteriaType;
	}



	public void setCriteriaType(CriteriaType criteriaType) {
		this.criteriaType = criteriaType;
	}

	private Filter criteria;
    private Filter otherCriteria;

    public Filter() {}



    public Filter( CriteriaType criteriaType,
                     Filter criteria, Filter otherCriteria) {

      
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

   



    public Filter getCriteria() {
        return criteria;
    }

    public Filter getOtherCriteria() {
        return otherCriteria;
    }
}
