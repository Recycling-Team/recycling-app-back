package com.recycleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recycleapp.model.Reservation;
import com.recycleapp.model.ReservationRepository;
import com.recycleapp.model.UserRepository;
import com.recycleapp.model.Usera;

@Controller
public class UserController {

    @Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UserRepository userRepo;

    @GetMapping(value = "/{userid}/reservations")
	public @ResponseBody List<Reservation> getAllReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<Usera> userListRest() {
        return (List<Usera>) userRepo.findAll();
    }


}