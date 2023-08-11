package com.m1guuel.workshop.resource;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.m1guuel.workshop.Repository.PostRepository;
import com.m1guuel.workshop.Repository.UserRepository;
import com.m1guuel.workshop.domain.Post;
import com.m1guuel.workshop.domain.User;
import com.m1guuel.workshop.dto.UserDTO;
import com.m1guuel.workshop.resource.util.URL;
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

	@GetMapping("/titlesearch")
	public ResponseEntity<List<Post>> findBytitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decoParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text",defaultValue = "")String text,
			@RequestParam(value = "minDate",defaultValue = "")String minDate,
		    @RequestParam(value = "maxDate",defaultValue = "")String maxDate) {
		text = URL.decoParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date(0));
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}

}