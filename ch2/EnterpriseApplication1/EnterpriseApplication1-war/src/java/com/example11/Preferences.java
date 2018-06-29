/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example11;

import java.io.Serializable;
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
    public PaymentStrategy getPaymentStrategy() {

        switch (paymentStrategy) {

            case CREDIT_CARD:
                return new CreditCardPaymentStrategy();

            case CHECK:
                return new CheckPaymentStrategy();

            case PAYPAL:
                return new PayPalPaymentStrategy();

            default:
                return null;

        }
    }
}
