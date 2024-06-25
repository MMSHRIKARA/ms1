package com.user.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

public interface UserrRepoistory extends MongoRepository<User,Long> {
	
	
//	Optional<User> findByName(String username);

	Optional<User> findByUsername(String username);

}
