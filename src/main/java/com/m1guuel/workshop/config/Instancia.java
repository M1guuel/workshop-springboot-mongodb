package com.m1guuel.workshop.config;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.m1guuel.workshop.Repository.PostRepository;
import com.m1guuel.workshop.Repository.UserRepository;
import com.m1guuel.workshop.domain.Post;
import com.m1guuel.workshop.domain.User;
import com.m1guuel.workshop.dto.author;
@Configuration
public class Instancia implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("01/03/2023"),"Vou viajar","Vou viajar para São Paulo",new author(maria));
		Post post2 = new Post(null,sdf.parse("08/01/2023"),"Tenha bom Dia","Bom Dia a todos",new author(maria));
		
		
	
		 postRepository.saveAll(Arrays.asList(post1,post2));

	}

}
