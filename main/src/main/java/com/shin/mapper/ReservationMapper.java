package com.shin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.shin.domain.reservation.Reservation;

@Mapper
@Component
public interface ReservationMapper {
	
	public List<Reservation> getReservations(Long userSeq);
}
