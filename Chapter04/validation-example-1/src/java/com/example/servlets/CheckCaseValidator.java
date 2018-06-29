/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlets;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author abdalla
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CheckCase.CaseType caseType;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        caseType = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        } else if (caseType == CheckCase.CaseType.UPPER) {
            return value.equals(value.toUpperCase());
        } else {
            return value.equals(value.toLowerCase());
        }
    }

}
