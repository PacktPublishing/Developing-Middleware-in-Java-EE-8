/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example12;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author abdalla
 */
@SessionScoped
public class Preferences implements Serializable {

    public static final int CREDIT_CARD = 0;
    public static final int CHECK = 1;
    public static final int PAYPAL = 2;
    private int paymentStrategy;

    @Produces
    @Preferred
    @RequestScoped
    public PaymentStrategy getPaymentStrategy(CreditCardPaymentStrategy ccps,
            CheckPaymentStrategy cps,
            PayPalPaymentStrategy ppps) {
        switch (paymentStrategy) {
            case CREDIT_CARD:
                return ccps;

            case CHECK:
                return cps;

            case PAYPAL:
                return ppps;

            default:
                return null;
        }
    }
}
