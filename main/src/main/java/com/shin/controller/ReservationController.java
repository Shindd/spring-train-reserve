package com.shin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.extern.slf4j.Slf4j;

import com.shin.domain.ApiResult;
import com.shin.domain.JsonViewSupport;
import com.shin.domain.reservation.Reservation;
import com.shin.domain.user.AppUser;
import com.shin.security.annotation.Authorized;
import com.shin.security.user.UserContextHolder;
import com.shin.service.ReservationService;

@Slf4j
@RestController("/v1")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Authorized
	@JsonView(JsonViewSupport.Summary.class)
	@GetMapping(value = "/reservations")
	public ResponseEntity getReservations() {
		AppUser appUser = UserContextHolder.get();
		List<Reservation> reservations = reservationService.getReservations(appUser.getUserSeq());
		return ResponseEntity.ok(ApiResult.ok(reservations));
	}
	
	@Authorized
	@PostMapping(value = "/reservation")
	public ResponseEntity makeReservation() {
		AppUser appUser = UserContextHolder.get();
		return ResponseEntity.ok(ApiResult.ok(null));
	}
}
