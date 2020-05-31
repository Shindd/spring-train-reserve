package com.shin.domain.City;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("City")
public class City {
	private String name;
	
	private String code;
}
