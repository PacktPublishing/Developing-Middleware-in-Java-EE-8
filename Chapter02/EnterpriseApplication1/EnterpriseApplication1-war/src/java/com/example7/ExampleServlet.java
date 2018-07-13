/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example7;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abdalla
 */
@WebServlet(urlPatterns = "/cdi-example-7")
public class ExampleServlet extends HttpServlet {

    @Inject
    private BookingHandler bookingHandler;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Booking booking = new Booking(1234, 1, 122, 241, (List<Long>) Arrays.asList(1L, 2L, 3L), new BigDecimal("123"));
        bookingHandler.book(booking);
    }

}
