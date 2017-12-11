package com.samyuktatech.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samyuktatech.document.User;
import com.samyuktatech.repository.UserRepository;
import com.samyuktatech.util.Utility;

@RestController
@RequestMapping("/")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	/**
	 * Save User document
	 * 
	 * @param user
	 * @param errors
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody com.samyuktatech.comman.model.User modelUser, Errors errors) {
		
		// Map user objects	from Model to Document
		User documentUser = Utility.userModelToDocument(modelUser);
		
		userRepository.save(documentUser);
		
	    return ResponseEntity.ok("Successfully saved.");		    
				
	}
	
	@GetMapping("/name")
	public ResponseEntity<?> searchByName(@RequestParam("query") String query) {
		
		List<User> users = userRepository.findByNameContaining(query);
		
		return ResponseEntity.ok(users);
		
	}
	
}
