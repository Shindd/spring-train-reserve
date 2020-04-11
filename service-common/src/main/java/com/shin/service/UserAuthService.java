package com.shin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import com.shin.domain.user.AppUser;
import com.shin.mapper.UserAuthMapper;

@Slf4j
@Component
public class UserAuthService {
	
	@Autowired
	private UserAuthMapper userAuthMapper;
	
	public AppUser selectUser(String loginId) {
		return userAuthMapper.selectAppUser(loginId);
	}

	public void updateLastAccessedAt(Long userSeq) {
		userAuthMapper.updateLastAccessedAt(userSeq);
	}
}
