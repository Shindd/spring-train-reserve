package com.shin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.shin.mapper.TrainMapper;

@Slf4j
@Service
public class TrainService {
	
	@Autowired
	private TrainMapper trainMapper;
	
	
}
