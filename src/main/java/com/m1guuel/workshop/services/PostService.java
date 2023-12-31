package com.m1guuel.workshop.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1guuel.workshop.Repository.PostRepository;
import com.m1guuel.workshop.Repository.UserRepository;
import com.m1guuel.workshop.domain.Post;
import com.m1guuel.workshop.domain.User;
import com.m1guuel.workshop.dto.UserDTO;
import com.m1guuel.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;

	public List<Post> findAll(){
		return repo.findAll();
		
	}
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public List<Post> findByTitle(String te){
		return repo.findByTitleContainingIgnoreCase(te);
	}
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
	
	
	
}
