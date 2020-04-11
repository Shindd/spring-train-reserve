package com.shin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;

import com.shin.domain.ApiResult;
import com.shin.domain.JsonViewSupport;
import com.shin.service.TrainService;

@Slf4j
@RestController
@RequestMapping("/v1/train")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	@JsonView(JsonViewSupport.Summary.class)
	@GetMapping(value = "/reservations")
	public ResponseEntity getReservations() {
		return ResponseEntity.ok(ApiResult.ok(trainService.getReservations()));
	}
}
