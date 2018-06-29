/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example8;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author abdalla
 */
@Dependent
public class BookingHandler {

    private @Inject @Success Event<Booking> bookingSuccessEvent;
    private @Inject @Failure Event<Booking> bookingFailedEvent;

    public void book(Booking booking) {
        try {
            // do booking
            bookingSuccessEvent.fire(booking);
        } catch (Exception e) {
            // booking failed
            bookingFailedEvent.fire(booking);
        }
    }
}
