package com.m1guuel.workshop.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.m1guuel.workshop.Repository.UserRepository;
import com.m1guuel.workshop.domain.Post;
import com.m1guuel.workshop.domain.User;
import com.m1guuel.workshop.dto.UserDTO;
import com.m1guuel.workshop.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(X -> new UserDTO(X)).collect(Collectors.toList());	
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User list = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(list));
	}
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User list = service.findById(id);
		return ResponseEntity.ok().body(list.getPosts());
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		   service.delete(id);
		return ResponseEntity.noContent().build();
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO obj,@PathVariable String id) {
		User list = service.fromDTO(obj);
		list.setId(id);
		list = service.update(list);
		return ResponseEntity.noContent().build();

	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO obj) {
		User list = service.fromDTO(obj);
		list = service.insert(list);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}