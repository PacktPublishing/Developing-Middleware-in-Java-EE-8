/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example8;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

/**
 *
 * @author abdalla
 */
@Dependent
public class BookingFailedNotifier {

    public void onBookingFailed(@Observes @Failure Booking booking) {
        System.out.println("New Booking failed with id " + booking.getId());
        // a notification mail should be sent to the user
    }
}
