package com.m1guuel.workshop.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1guuel.workshop.Repository.UserRepository;
import com.m1guuel.workshop.domain.User;
import com.m1guuel.workshop.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
