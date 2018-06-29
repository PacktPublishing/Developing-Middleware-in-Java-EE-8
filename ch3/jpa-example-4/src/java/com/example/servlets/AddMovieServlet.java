/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servlets;

import com.example.beans.MovieBean;
import com.example.entities.Movie;
import com.example.entities.MovieInfo;
import java.io.IOException;
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
@WebServlet(urlPatterns = "/add-movie")
public class AddMovieServlet extends HttpServlet {

    @Inject
    private MovieBean movieBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieTitle = request.getParameter("movie_title");

Movie movie = new Movie();
movie.setTitle("Beauty and the Beast");

MovieInfo movieInfo = new MovieInfo();
movieInfo.setStoryLine("A young prince, imprisoned in the form of a beast, can be freed only by true love.");
movieInfo.setRuntime(129);
movieInfo.setLanguage("English");
movieInfo.setCountry("USA");

movie.setMovieInfo(movieInfo);
                

        movieBean.insert(movie);

    }

}
