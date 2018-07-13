/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlets;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

/**
 *
 * @author abdalla
 */
@Documented
@Constraint(validatedBy = CheckCaseValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Size(max = 10)
public @interface CheckCase {

    String message() default "{com.example.validation.CheckCase} {type}!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    CaseType type() default CaseType.UPPER;

    public static enum CaseType {
        UPPER {
            @Override
            public String toString() {
                return "uppercase";
            }
        }, LOWER {
            @Override
            public String toString() {
                return "lowercase";
            }
        }
    }
}
