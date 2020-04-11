package com.shin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.shin.domain.user.AppUser;

@Mapper
@Component
public interface UserAuthMapper {
	
	public AppUser selectAppUser(String loginId);
	
	public void updateLastAccessedAt(Long userSeq);
}
