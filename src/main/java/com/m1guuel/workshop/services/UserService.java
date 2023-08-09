package com.m1guuel.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1guuel.workshop.Repository.UserRepository;
import com.m1guuel.workshop.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
		
	}
	
}
