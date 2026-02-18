package com.felipealb.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipealb.workshopmongo.DTO.UserDTO;
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
	
	public User insert(User obj) {
		return repository.insert(obj);
				
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User userData = findById(obj.getId());
		updateData(userData, obj);
		return repository.save(userData);
	}
	
	private void updateData(User userData, User obj) {
		userData.setId(obj.getId());
		userData.setName(obj.getName());
		userData.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDto) {
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
