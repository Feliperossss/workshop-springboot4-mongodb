package com.felipealb.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipealb.workshopmongo.DTO.UserDTO;
import com.felipealb.workshopmongo.domain.Post;
import com.felipealb.workshopmongo.domain.User;
import com.felipealb.workshopmongo.repository.PostRepository;
import com.felipealb.workshopmongo.service.exception.ObjectNotFoundException;

@Service	
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.orElseThrow(() ->  new ObjectNotFoundException("post not found"));
	}
	
	public Post insert(Post obj) {
		return repository.insert(obj);
				
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Post update(Post obj) {
		Post postData = findById(obj.getId());
		updateData(postData, obj);
		return repository.save(postData);
	}
	
	private void updateData(Post postData, Post obj) {
		postData.setId(obj.getId());
		postData.setDate(obj.getDate());
		postData.setTitle(obj.getTitle());
		postData.setBody(obj.getBody());
	}
	
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
	
}
