package com.m1guuel.workshop.resource;

import java.util.List;
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

import com.m1guuel.workshop.Repository.PostRepository;
import com.m1guuel.workshop.Repository.UserRepository;
import com.m1guuel.workshop.domain.Post;
import com.m1guuel.workshop.domain.User;
import com.m1guuel.workshop.dto.UserDTO;
import com.m1guuel.workshop.services.PostService;
import com.m1guuel.workshop.services.UserService;

@RestController
@RequestMapping(value = "/post")
public class PostResource {
	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		List<Post> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
	Post list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}

}