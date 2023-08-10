package com.m1guuel.workshop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.m1guuel.workshop.domain.Post;
import com.m1guuel.workshop.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
