package com.recycleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recycleapp.model.Reservation;
import com.recycleapp.model.ReservationRepository;

@Controller
public class UserController {

    @Autowired
	private ReservationRepository reservationRepository;
    @GetMapping(value = "/{userid}/reservations")
	public @ResponseBody List<Reservation> getAllReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}
}