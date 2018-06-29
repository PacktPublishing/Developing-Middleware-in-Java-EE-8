/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example7;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 *
 * @author abdalla
 */
@Dependent
public class BookingHandler {

    private @Inject @Any Event<Booking> booEvent;

    public void book(Booking booking) {
        // do booking
        booEvent.fire(booking);
    }
}
