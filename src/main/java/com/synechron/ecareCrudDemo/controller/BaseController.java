package com.synechron.ecareCrudDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.ecareCrudDemo.model.User;
import com.synechron.ecareCrudDemo.repository.UserInterface;

@RestController
public class BaseController {
	
	@Autowired
	private UserInterface userInterface ;
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome page";
	}

	@RequestMapping("/saveManually")
	public String saveUser() {
		
		User u1 = new User(); 
		u1.setId(1);
		u1.setName("Synechron");
		u1.setOccupation("Software Industry");
		userInterface.save(u1);
		
		u1.setId(2);
		u1.setName("HSBC");
		u1.setOccupation("Banking ");
		userInterface.save(u1);
		
		u1.setId(3);
		u1.setName("CITI");
		u1.setOccupation("Banking ");
		userInterface.save(u1);
		return "saved....";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@Valid @RequestBody User user) {
		userInterface.save(user);
		return "Saved via System";
	}
	
	@RequestMapping("/getAllUser")
	public List<User> getAllUser() {
		return userInterface.findAll();
	}
	
}
