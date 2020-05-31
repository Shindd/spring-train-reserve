package com.shin.domain.reservation;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("Reservation")
public class Reservation {
	
	private String reservationSeq;
	
	private String from;
	
	private String to;
	
	private Date date;
	
	private Integer price;
}
