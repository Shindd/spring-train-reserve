package com.shin.service;

import static org.springframework.http.MediaType.*;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

import com.shin.domain.City.City;
import com.shin.domain.train.Train;
import com.shin.exception.ServiceException;
import com.shin.mapper.TrainMapper;

@Slf4j
@Service
public class TrainService {
	
	@Value("#{'${openapi.tago.url.find-trains}'}")
	private String findTrainsUrl;
	
	@Value("#{'${openapi.tago.private-key}'}")
	private String privateKey;
	
	@Autowired
	private TrainMapper trainMapper;
	
	public List<City> getCities() {
		ResponseEntity<byte[]> result;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(APPLICATION_FORM_URLENCODED); // TODO: add headers if need
			
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("ServiceKey", privateKey);
			
			HttpEntity<MultiValueMap> entity = new HttpEntity<>(params, headers);
			result = restTemplate.exchange(findTrainsUrl, HttpMethod.GET, entity, byte[].class);
		} catch (HttpClientErrorException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return null;
	}
	
	public List<Train> findTrains(String arriveCity, String departureCity, Date searchAtStartRange, Date searchAtRangeEnd) {
		
		return null;
	}
}
