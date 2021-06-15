package com.synechron.ecareCrudDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.ecareCrudDemo.exception.ResourceNotFoundException;
import com.synechron.ecareCrudDemo.model.User;
import com.synechron.ecareCrudDemo.repository.UserInterface;

@RestController
@RequestMapping("/")
public class BaseController {
	
	@Autowired
	private UserInterface userInterface ;
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome page";
	}

	@GetMapping(path="saveManually")
	public String saveUser() {
		
		User u1 = new User(); 
		u1.setName("India");
		u1.setOccupation("Software Industry");
		userInterface.save(u1);
		
		u1.setName("Japan");
		u1.setOccupation("Banking ");
		userInterface.save(u1);
		
		u1.setName("America");
		u1.setOccupation("Banking ");
		userInterface.save(u1);
		return "saved....";
	}
	
	@GetMapping(path="saveUser")
	public String saveUser(@Valid @RequestBody User user) {
		userInterface.save(user);
		return "Saved via System";
	}
	
	@RequestMapping("/getAllUser")
	public List<User> getAllUser() {
		return userInterface.findAll();
	}
	
	@GetMapping("getUser/{id}")
	public ResponseEntity<User> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException
	{
		User user = userInterface.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not availabe "));
		return ResponseEntity.ok().body(user);
		
	}
	
	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value="id") long id) throws ResourceNotFoundException{
		User user = userInterface.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wrong user Id entered"+ id));
		userInterface.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
}
