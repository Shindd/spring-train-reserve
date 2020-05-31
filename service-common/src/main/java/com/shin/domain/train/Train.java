package com.shin.domain.train;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import lombok.Data;

import com.shin.code.TrainType;

@Data
@Alias("Train")
public class Train {
	
	private String trainSeq;
	
	private String number;
	
	private TrainType trainType;
	
	private Date departureDate;
	
	private Date arriveDate;
}
