/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlets;

import com.example.beans.MovieBean;
import com.example.entities.Movie;
import java.io.IOException;
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
@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Inject
    private MovieBean movieBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Movie movie = movieBean.test();
        resp.getOutputStream().println(movie.getTitle());
    }

}
