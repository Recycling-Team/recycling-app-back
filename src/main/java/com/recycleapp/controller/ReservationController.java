package com.recycleapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recycleapp.model.Reservation;
import com.recycleapp.model.ReservationRepository;

@CrossOrigin
@Controller
public class ReservationController {
    

	@Autowired
    private ReservationRepository reservationRepo;

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public @ResponseBody List<Reservation> reservationListRest() {
        return (List<Reservation>) reservationRepo.findAll();
    }

    

    @PostMapping("/savereservation")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        reservationRepo.save(reservation);
        return "redirect:/";
    }
    
}
