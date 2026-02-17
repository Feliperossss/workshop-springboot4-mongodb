package com.felipealb.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipealb.workshopmongo.domain.User;
import com.felipealb.workshopmongo.repository.UserRepository;

@Service	
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
