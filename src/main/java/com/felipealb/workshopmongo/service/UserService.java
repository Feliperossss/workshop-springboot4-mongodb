package com.felipealb.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipealb.workshopmongo.domain.User;
import com.felipealb.workshopmongo.repository.UserRepository;
import com.felipealb.workshopmongo.service.exception.ObjectNotFoundException;

@Service	
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() ->  new ObjectNotFoundException("User not found"));
	}
}
