/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example7;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author abdalla
 */
public class Booking {

    private long id;
    private long cinemaId;
    private long slotId;
    private long filmId;
    private List<Long> seatIds;
    private BigDecimal amountPaid;

    public Booking() {
    }

    public Booking(long id, long cinemaId, long slotId, long filmId, List<Long> seatIds, BigDecimal amountPaid) {
        this.id = id;
        this.cinemaId = cinemaId;
        this.slotId = slotId;
        this.filmId = filmId;
        this.seatIds = seatIds;
        this.amountPaid = amountPaid;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the cinemaId
     */
    public long getCinemaId() {
        return cinemaId;
    }

    /**
     * @param cinemaId the cinemaId to set
     */
    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * @return the slotId
     */
    public long getSlotId() {
        return slotId;
    }

    /**
     * @param slotId the slotId to set
     */
    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    /**
     * @return the filmId
     */
    public long getFilmId() {
        return filmId;
    }

    /**
     * @param filmId the filmId to set
     */
    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    /**
     * @return the seatIds
     */
    public List<Long> getSeatIds() {
        return seatIds;
    }

    /**
     * @param seatIds the seatIds to set
     */
    public void setSeatIds(List<Long> seatIds) {
        this.seatIds = seatIds;
    }

    /**
     * @return the amountPaid
     */
    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

}
