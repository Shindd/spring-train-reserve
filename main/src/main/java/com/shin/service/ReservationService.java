package com.shin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import com.shin.domain.reservation.Reservation;
import com.shin.mapper.ReservationMapper;

@Slf4j
@Service
public class ReservationService {
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	@Transactional(readOnly = true)
	public List<Reservation> getReservations(Long userSeq) {
		return reservationMapper.getReservations(userSeq);
	}
}
